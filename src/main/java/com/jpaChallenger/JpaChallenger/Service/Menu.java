package com.jpaChallenger.JpaChallenger.Service;


import com.jpaChallenger.JpaChallenger.model.Cancion;
import com.jpaChallenger.JpaChallenger.model.Cantante;
import com.jpaChallenger.JpaChallenger.repository.SingerRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.zip.DataFormatException;

public class Menu {
    SingerRepository singerRepository;
    Scanner sc=new Scanner(System.in);

    public Menu(SingerRepository singerRepository) {
        this.singerRepository=singerRepository;
    }

    public void menu(){
        int op;
        do{
            System.out.println("""
                    Menu
                    1.Registrar cantante
                    2.Registrar cancion
                    3.Buscar canciones por cantante""");
            op= sc.nextInt();
            switch (op){
                case 1:
                    createSinger().ifPresent(sin->{
                        singerRepository.save(sin);
                    });
                    //singerRepository.save(cantante);
                   // System.out.println(cancion);
                   // var singer=singerRepository.findById(1L).get();
                  //  System.out.println(singer);
                   /* Cancion cancion2=new Cancion("True Blue",4.29,"Papa dont Preach");
                    singer.addSong(cancion2);
                    singerRepository.save(singer);
*/
                   /*cancion.setSinger(singer);
                    singer.addSong(cancion);
                    singerRepository.save(singer);*/
                    Cantante cantante2=new Cantante("Kurt","Cobain",27,"Abeerden,Washington",LocalDate.of(1967,2,20),"Estadounidense","rock");
                    Cancion cancion2=new Cancion("Nevermind",3.44,"Come As Your Are");
                    cantante2.addSong(cancion2);
                    singerRepository.save(cantante2);

                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;


            }

        }while(op!=0);


    }
    private Optional<Cantante> createSinger(){
        Cantante singer=null;
        try{
            System.out.println("Ingrese el nombre del cantante ");
            String name= sc.nextLine();
            System.out.println("Ingrese el apellido del cantante");
            String lastName=sc.nextLine();
            System.out.println("Ingrese la edad del cantante");
            int age= sc.nextInt();
            System.out.println("Ingrese en ciudad nacio el cantante");
            String city=sc.nextLine();
            System.out.println("Ingrese la nacionalidad del cantante");
            String nationality=sc.nextLine();
            System.out.println("Ingrese cual es su estilo musical puede pop,rock");
            String style=sc.nextLine();
            System.out.println("A continuacion se le solicitara la fecha de nacimiento del cantante");
            System.out.println("En que anio nacio");
            int year= sc.nextInt();
            System.out.println("En que mes nacio");
            int month=sc.nextInt();
            System.out.println("En que dia nacio");
            int day= sc.nextInt();
            LocalDate birthDay=LocalDate.of(year,month,day);

           singer=new Cantante(name,lastName,age,city,birthDay,nationality,style);


        }catch (InputMismatchException e){
            System.out.println("No ha ingresado un valor correcto");
        }catch (DateTimeException e){
            System.out.println("Fecha formada incorrectamente");
        }finally {
            sc.nextLine();
        }
        return Optional.ofNullable(singer);

    }
}
