package main;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {

    }
    class MovieRentingSystem {
        class Node{
            int shop;
            int movie;
            int price;

            public Node(int shop, int movie, int price) {
                this.shop = shop;
                this.movie = movie;
                this.price = price;
            }

            public int getShop() {
                return shop;
            }

            public int getMovie() {
                return movie;
            }

            public int getPrice() {
                return price;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "shop=" + shop +
                        ", movie=" + movie +
                        ", price=" + price +
                        '}';
            }
        }
        TreeSet<Node> rentedMovie = new TreeSet<>((a,b)-> {
            if(a.price != b.price)
                return a.price - b.price;
            return a.shop - b.shop;

        });
        HashMap<Integer, HashMap<Integer, Node>> movieMap  = new HashMap<>();
        HashMap<Integer, TreeSet<Node>> movieSearch  = new HashMap<>();
         public MovieRentingSystem(int n, int[][] entries) {
             for(int[] arr: entries)
             {
                 Node node = new Node(arr[0], arr[1], arr[2]);
                 if(!movieMap.containsKey(node.shop))
                     movieMap.put(node.shop, new HashMap<>());
                 if(!movieMap.get(node.shop).containsKey(node.movie)){
                     movieMap.get(node.shop).put(node.movie, node);
                     movieSearch.put(node.movie, new TreeSet<>((a,b) -> {
                         if(a.price != b.price)
                             return a.price - b.price;
                         return a.shop - b.shop;
                     }));
                     movieSearch.get(node.movie).add(node);
                 }
                 else{
                     Node node1 = movieMap.get(node.shop).get(node.movie);
                     movieSearch.get(node1.movie).remove(node1);
                     node1.price = node.price;
                     movieSearch.get(node.movie).add(node1);
                 }

             }


        }

        public List<Integer> search(int movie) {
            if(movieSearch.containsKey(movie))
            {
                movieSearch.get(movie).stream().sorted().map(Node::getPrice).limit(5).toList();
            }
            return new ArrayList<>();

        }

        public void rent(int shop, int movie) {
             Node node = movieMap.get(shop).get(movie);
             movieSearch.get(movie).remove(node);
             rentedMovie.add(node);

        }

        public void drop(int shop, int movie) {
            Node node = movieMap.get(shop).get(movie);
            rentedMovie.remove(node);
            movieSearch.get(movie).add(node);

        }

        public List<List<Integer>> report() {
            List<List<Integer>>  res= new ArrayList<>();
            rentedMovie.stream().sorted().limit(5).forEach((node)->{
                List<Integer> r1 = new ArrayList<>();
                r1.add(node.shop);
                r1.add(node.price);
                res.add(r1);
            });

            return res;




        }
    }


}