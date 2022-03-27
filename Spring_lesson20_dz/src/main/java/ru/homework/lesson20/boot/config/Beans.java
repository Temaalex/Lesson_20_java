package ru.homework.lesson20.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.homework.lesson20.boot.func.*;
import ru.homework.lesson20.boot.interfaces.Logger;

@Configuration
public class Beans {
    @Bean("add")
    public Logger AddNewParam(){
        return new AddNewParam();
    }
    @Bean("buy")
    public Logger  BuyTicket(){
        return new BuyTicket();
    }
    @Bean("change")
    public Logger  ChangeParam(){
        return new ChangeParam();
    }
    @Bean("delete")
    public Logger  DeleteParam(){
        return new DeleteParam();
    }
    @Bean("look")
    public Logger  LookAllParam(){
        return new LookAllParam();
    }
    @Bean("sale")
    public Logger  SaleTicket(){
        return new SaleTicket();
    }



}
