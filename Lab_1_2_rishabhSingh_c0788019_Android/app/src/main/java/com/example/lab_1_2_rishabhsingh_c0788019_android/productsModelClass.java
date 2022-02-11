package com.example.lab_1_2_rishabhsingh_c0788019_android;

public class productsModelClass {
       private  int id;
       private  String name;
       private  String Description;
       private  double price;
       private  double latitude;
       private  double longitude;

       public productsModelClass(int id, String name, String description, double price, double latitude, double longitude) {
              this.id = id;
              this.name = name;
              Description = description;
              this.price = price;
              this.latitude = latitude;
              this.longitude = longitude;
       }

       @Override
       public String toString() {
              return  "           " + id + "                 " + name + "                   "  + price ;
       }

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getName() {
              return name;
       }

       public void setName(String name) {
              this.name = name;
       }

       public String getDescription() {
              return Description;
       }

       public void setDescription(String description) {
              Description = description;
       }

       public double getPrice() {
              return price;
       }

       public void setPrice(double price) {
              this.price = price;
       }

       public double getLatitude() {
              return latitude;
       }

       public void setLatitude(double latitude) {
              this.latitude = latitude;
       }

       public double getLongitude() {
              return longitude;
       }

       public void setLongitude(double longitude) {
              this.longitude = longitude;
       }
}
