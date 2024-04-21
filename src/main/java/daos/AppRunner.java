package daos;

import java.util.ArrayList;
import java.util.List;

public class AppRunner {

    public static void main(String[] args) {

        DAO bikesDao =  new DAO();
        Bikes bike3 = new Bikes("Cervelo","Caledonia-5",2023,"Pearl-White", 48, 3);
        Bikes bike4 = new Bikes("Giant", "Defy", 2020,"Red", 55, 4);
        Bikes bike5 = new Bikes("Bianchi", "Infinito", 2018, "Black", 62, 5);
        Bikes toBeDeleted = new Bikes("ldksjfk", "fjiwefi", 1234,"jnvsfn",23, 6);

        // Create
//        bikesDao.create(bike3);
//        bikesDao.create(bike4);
//        bikesDao.create(bike5);
//        bikesDao.create(toBeDeleted);


        // Findall
        List<Bikes> bikeList = bikesDao.findAll();
        bikesDao.printBikeList(bikeList);

        //update  id=4 change the year from 2020 to 2024
//        Bikes updateBike4 = new Bikes("Giant", "Defy", 2024,"Red", 55, 4);
        System.out.println("\n\n\n");
//        bikesDao.update(updateBike4);
        bikesDao.printBikeList(bikeList);

        //delete Id:6
//        bikesDao.delete(6);




    }
}
