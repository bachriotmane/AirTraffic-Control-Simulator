package fsts.simulation;

import fsts.simulation.dao.AiroportRepo;
import fsts.simulation.dao.AvionRepo;
import fsts.simulation.entity.*;
import fsts.simulation.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SimulationApplication  implements CommandLineRunner{

	@Autowired
	AeroportService aeroportService;

	@Autowired
	LocalisationService localisationService;
	@Autowired
	AvionService avionService;
	@Autowired
	AiroportRepo airoportRepo;
	@Autowired
	VolService volService;
	public static void main(String[] args) {
		SpringApplication.run(SimulationApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Localisation lMaroc = new Localisation(445,357,0);
		Localisation lAlgerie = new Localisation(486,363,0);
		Localisation lSpain = new Localisation(460,346,0);
		Localisation lFrance = new Localisation(480,310,0);
		Localisation laGreenland = new Localisation(350,181,0);
		Localisation lAlmand = new Localisation(501,298,0);
		Localisation lSaudi= new Localisation(590,387,0);
		Localisation lLibya= new Localisation(522,373,0);
		Localisation lChad= new Localisation(527,427,0);
		Localisation lRussia= new Localisation(751,218, 0);
		Localisation lMangulia= new Localisation(755,310,0);
		Localisation lBrazil= new Localisation(332,489,0);

		Airoport aMaroc = new Airoport("Mohamed 5 Aeroprt" ,90,45,00,45,
				100,3,5,lMaroc,true, null );

		Airoport aAlgerie = new Airoport("No Banae Aeroprt" ,90,45,00,45,
				100,3,5,lAlgerie,true ,null);

		Airoport aSpain = new Airoport("Spain Aeroprt" ,90,45,00,45,
				100,3,5,lSpain,true ,null);
		Airoport aFrance = new Airoport("France Aeroprt" ,90,45,00,45,
				100,3,5,lFrance,true, null );
		Airoport aGreenland = new Airoport("Greenland Aeroprt" ,90,45,00,45,
				100,3,5,laGreenland,true, null );
		Airoport aAlmand = new Airoport("Almand Aeroprt" ,90,45,00,45,
				100,3,5,lAlmand,true , null);
		Airoport aSaudi = new Airoport("Saudi Aeroprt" ,90,45,00,45,
				100,3,5,lSaudi,true, null );
		Airoport aLibya = new Airoport("Libya Aeroprt" ,90,45,00,45,
				100,3,5,lLibya,true , null);
		Airoport aChad = new Airoport("Chad Aeroprt" ,90,45,00,45,
				100,3,5,lChad,true ,null);
		Airoport aRussia = new Airoport("Russia Aeroprt" ,90,45,00,45,
				100,3,5,lRussia,true ,null);
		Airoport aMangulia = new Airoport("Mangulia Aeroprt" ,90,45,00,45,
				100,3,5,lMangulia,true ,null);
		Airoport aBrazil = new Airoport("Brazil Aeroprt" ,90,45,00,45,
				100,3,5,lBrazil,true , null);

		aeroportService.saveAiroport(aMaroc);
		aeroportService.saveAiroport(aAlgerie);
		aeroportService.saveAiroport(aSpain);
		aeroportService.saveAiroport(aFrance);
		aeroportService.saveAiroport(aGreenland);
		aeroportService.saveAiroport(aAlmand);
		aeroportService.saveAiroport(aSaudi);
		aeroportService.saveAiroport(aLibya);
		aeroportService.saveAiroport(aChad);
		aeroportService.saveAiroport(aRussia);
		aeroportService.saveAiroport(aMangulia);
		aeroportService.saveAiroport(aBrazil);

		Avion av1 = new Avion(100,3100,TypeAvion.LONG,aMaroc.getLocalisation(),false);
		av1.setAiroport(aMaroc);
		Avion av2 = new Avion(50,1200,TypeAvion.MOYEN,aSpain.getLocalisation(),false);
		av2.setAiroport(aMaroc);
		Avion av3 = new Avion(100,2900,TypeAvion.LONG,aSaudi.getLocalisation(),false);
		av3.setAiroport(aMaroc);
		Avion av4 = new Avion(100,2000,TypeAvion.LONG,aGreenland.getLocalisation(),false);
		av4.setAiroport(aMaroc);
		Avion av5 = new Avion(30,500,TypeAvion.COURT,aGreenland.getLocalisation(),false);
		av5.setAiroport(aMaroc);
		Avion av6 = new Avion(100,2090,TypeAvion.LONG,aGreenland.getLocalisation(),false);
		av6.setAiroport(aRussia);
		Avion av7 = new Avion(30,460,TypeAvion.COURT,aGreenland.getLocalisation(),false);
		av7.setAiroport(aRussia);
		Avion av8 = new Avion(100,2600,TypeAvion.LONG,aGreenland.getLocalisation(),false);
		av8.setAiroport(aRussia);
		Avion av9 = new Avion(50,1090,TypeAvion.MOYEN,aGreenland.getLocalisation(),false);
		av9.setAiroport(aRussia);
		Avion av10 = new Avion(50,1090,TypeAvion.MOYEN,aGreenland.getLocalisation(),false);
		av10.setAiroport(aRussia);

		avionService.saveAvion(av1);
		avionService.saveAvion(av2);
		avionService.saveAvion(av3);
		avionService.saveAvion(av4);
		avionService.saveAvion(av5);
		avionService.saveAvion(av6);
		avionService.saveAvion(av7);
		avionService.saveAvion(av8);
		avionService.saveAvion(av9);
		avionService.saveAvion(av10);

		Vol v1 = new Vol(aMaroc,aRussia,new Date(),new Date(),av1);
		Vol v2 = new Vol(aRussia,aBrazil,new Date(),new Date(),av2);
		Vol v3 = new Vol(aSpain,aFrance,new Date(),new Date(),av6);
		Vol v4 = new Vol(aGreenland,aMangulia,new Date(),new Date(),av4);
		Vol v5 = new Vol(aSpain,aMangulia,new Date(),new Date(),av4);
		Vol v6 = new Vol(aSpain,aBrazil,new Date(),new Date(),av4);


		volService.saveVol(v1);
		volService.saveVol(v2);
		volService.saveVol(v3);
		volService.saveVol(v4);
		volService.saveVol(v5);
		volService.saveVol(v6);

	}
}
