package com.example.fonctionsmathmatiques.model;

public class Factorielle {

    private int data, result;

    public Factorielle(int data){
        this.data = data;
        result = factorille();
    }

    public int getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

    public int factorille(){
        int p = 1;
        for (int i=2; i<=data;i++){
            p = p*i;
        }
        return p;
    }
}