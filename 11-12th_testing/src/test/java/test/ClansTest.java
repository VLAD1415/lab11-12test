package test;

import page.*;
import org.testng.annotations.Test;

public class ClansTest extends CommonConditions {
    @Test(description = "Найти футболки через строку поиска")
    public void ClansTest1(){
        new HomePage(driver).openPage()
                .searchQuery("футболки")
                .showResultOfSearch();
    }

    @Test(description = "Найти всю одежду бренда CARHART и отсортировать по цене")
    public void ClansTest2(){
        new HomePage(driver).openPage()
                .openBrandPage()
                .selectCarhartt()
                .setPriceFilter();
    }

    @Test(description = "Подписаться на рассылку")
    public void ClansTest3(){
        new HomePage(driver).openPage()
                .formailing("mashkan15st@gmail.com");



    }

    @Test(description = "Найти джинсы, отсортировать по цене и добавить в избранное ")
    public void ClansTest4(){
        new HomePage(driver).openPage()
                .searchQuery("джинсы")
                .showResultOfSearch()
                .setPriceFilter()

                .selectFirstItem()
                .addToFav();


    }


}
