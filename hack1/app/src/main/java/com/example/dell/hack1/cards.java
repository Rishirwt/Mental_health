package com.example.dell.hack1;

import java.util.ArrayList;

public class cards {
    String url;


    String content;
    public cards(String url, String content) {
        this.url = url;
        this.content = content;
    }

    public cards() {
        }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }
    public static ArrayList<cards> getrandom()
    {
        ArrayList<cards> techers=new ArrayList<>();

        techers.add(new cards("https://www.verywellmind.com/thmb/0LrgTovXHuEkDu4kiqstFqpzf_0=/2082x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/483612171-56a794393df78cf7729751a9.jpg","The term psychological disorder is sometimes used to refer to what is more frequently known as mental disorders or psychiatric disorders. Mental disorders are patterns of behavioral or psychological symptoms that impact multiple areas of life. "));
        techers.add(new cards("https://www.verywellmind.com/thmb/lVWd_1EXVuPoIJ7ZRqXj59uBYPk=/2082x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/173063457-56a7943c3df78cf7729751c7.jpg","Bipolar disorder is characterized by shifts in mood as well as changes in activity and energy levels. "));
        techers.add(new cards("https://www.verywellmind.com/thmb/jU8eopt_rx7tG0qXbfd3nn6Z_A4=/2084x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/470621641-56a794443df78cf772975211.jpg","Bipolar disorder is characterized by shifts in mood as well as changes in activity and energy levels. "));
        techers.add(new cards("https://www.verywellmind.com/thmb/8Rui_GMYIrYAzp6bgjye2FXju68=/2084x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/456771779-56a794423df78cf772975200.jpg","Bipolar disorder is characterized by shifts in mood as well as changes in activity and energy levels. "));
        techers.add(new cards("https://www.verywellmind.com/thmb/DFdHOXjG7L2eFgPsXr-85hy1dJ8=/2082x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/children-coloring-with-army-seabag-in-background-180690924-59fe0d969e9427003cf074b5.jpg","Bipolar disorder is characterized by shifts in mood as well as changes in activity and energy levels. "));

        return techers;
    }
}
