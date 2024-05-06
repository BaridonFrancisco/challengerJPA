package com.jpaChallenger.JpaChallenger.Service;


import com.jpaChallenger.JpaChallenger.model.Cantante;
import com.jpaChallenger.JpaChallenger.repository.SingerRepository;

import java.time.LocalDate;
import java.util.Scanner;

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
                    1.Ingrese un cantante""");
            op= sc.nextInt();
            switch (op){
                case 1:
                    Cantante cantante=new Cantante("Louise","Madona",
                            65,"Bay city,Michigan", LocalDate.of(1958,7,16),"Estadonidense","pop");

                    singerRepository.save(cantante);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;


            }

        }while(op!=0);


    }
}
