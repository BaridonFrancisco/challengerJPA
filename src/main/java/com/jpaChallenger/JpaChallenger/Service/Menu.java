package com.jpaChallenger.JpaChallenger.Service;


import com.jpaChallenger.JpaChallenger.model.Singer;
import com.jpaChallenger.JpaChallenger.model.Song;
import com.jpaChallenger.JpaChallenger.model.Style;
import com.jpaChallenger.JpaChallenger.repository.SingerRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

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
                    2.Registrar cancion para un cantante
                    3.Mostrar todas las canciones
                    4.Buscar cantante
                    5.Buscar canciones por  cantante
                    0.Salir""");
            op= sc.nextInt();
            switch (op){
                case 1:
                    createSinger().ifPresent(sin->{
                        singerRepository.save(sin);
                    });
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del cantante");
                    String name=sc.nextLine();
                    var optionalSinger=singerRepository.findByName(name);

                    optionalSinger.ifPresent(singer -> {
                        var song =createSong();
                        if(song!=null){
                            singer.addSong(song);
                            song.setSinger(singer);
                            singerRepository.save(singer);
                        }else{
                            System.out.println("No se ha podido crear la cancion para el cantante");
                        }

                    });
                case 3:
                    List<Singer>listSinger=singerRepository.findAll();
                    listSinger.forEach(singer->singer.getListSongs().forEach(System.out::println));
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del cantante");
                    String singer=sc.nextLine();
                    var re=singerRepository.findByName(singer);
                    if(re.isPresent()){
                        System.out.println(re.get());
                    }else {
                        System.out.println("Cantante no encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el estilo del cantante");
                    var ss=singerRepository.findSongsBySinger("Open your Heart");
                    System.out.println(ss);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;


            }
        }while(op!=0);
        sc.close();

    }
    private Optional<Singer> createSinger(){
        Singer singer=null;
        try{
            sc.nextLine();
            System.out.println("Ingrese el nombre del cantante ");
            String name= sc.nextLine();
            System.out.println("Ingrese el apellido del cantante");
            String lastName=sc.nextLine();
            System.out.println("Ingrese la edad del cantante");
            int age= sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese en ciudad nacio el cantante");
            String city=sc.nextLine();
            System.out.println("Ingrese la nacionalidad del cantante");
            String nationality=sc.nextLine();
            System.out.println("Ingrese cual es su estilo musical puede pop,rock");
            Style style=Style.fromStyle(sc.nextLine());
            System.out.println("A continuacion se le solicitara la fecha de nacimiento del cantante");
            System.out.println("En que anio nacio");
            int year= sc.nextInt();
            System.out.println("En que mes nacio");
            int month=sc.nextInt();
            System.out.println("En que dia nacio");
            int day= sc.nextInt();
            LocalDate birthDay=LocalDate.of(year,month,day);
            singer=new Singer(name,lastName,age,city,birthDay,nationality,style);
        }catch (InputMismatchException e){
            System.out.println("No ha ingresado un valor correcto");
        }catch (DateTimeException e){
            System.out.println("Fecha formada incorrectamente");
        }
        return Optional.ofNullable(singer);

    }
    public  Song createSong(){
        try{
            sc.nextLine();
            System.out.println("Ingrese el nonbre del album");
            String album=sc.nextLine();
            System.out.println("Ingrese el nombre de la cancion");
            String name=sc.nextLine();
            System.out.println("Ingrese la duracion de la cancion ");
            Double duration=sc.nextDouble();
            return new Song(album,duration,name);
        }catch (InputMismatchException e){
            System.out.println("Error entrada incorrecta "+e.getMessage());
        }catch (Exception e){
            System.out.println("Ha ocurrido una excepcion");
        }finally {
            sc.nextLine();
        }
        return null;
    }


}
