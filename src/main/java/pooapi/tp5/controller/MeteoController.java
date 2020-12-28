package pooapi.tp5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pooapi.tp5.model.AdressesResult;
import pooapi.tp5.model.Meteo;

import java.text.DecimalFormat;

@Controller

public class MeteoController {
    @PostMapping("/meteo")
    public String result(@RequestParam(value="adresse") String adressePOST, Model model) {
        model.addAttribute("nomTemplate", adressePOST);
        //System.out.println(adressePOST);

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://api-adresse.data.gouv.fr/search/?q=" + adressePOST + "&limit=1";

        ResponseEntity<AdressesResult> response = restTemplate.getForEntity(fooResourceUrl, AdressesResult.class);

        String lon = response.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(0);
        String lat = response.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(1);
        String label = response.getBody().getFeatures().get(0).getProperties().getLabel();

        model.addAttribute("lon", lon);
        model.addAttribute("lat", lat);
        model.addAttribute("label", label);

        RestTemplate restTemplate2 = new RestTemplate();
        String fooResourceUrl2 = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=75fc5ee8b7b1b66ca7a543164c52d70d";

        ResponseEntity<Meteo> response2 = restTemplate2.getForEntity(fooResourceUrl2, Meteo.class);

        DecimalFormat df = new DecimalFormat("#.##");
        double temp = (response2.getBody().getMain().getTemp()) - 273.15;
        String temp2 = df.format((temp));
        model.addAttribute("temp2", temp2);

        return "meteo";
    }
}
