package com.example.carlosjose95.peluchitosapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Peluchito implements Parcelable {
    private String id;
    private String nombre;
    private String cantidad;
    private String precio;

    public Peluchito(){
        id = "";
        nombre = "";
        cantidad = "";
        precio = "";
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }

    protected Peluchito(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        cantidad = in.readString();
        precio = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(cantidad);
        dest.writeString(precio);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Peluchito> CREATOR = new Parcelable.Creator<Peluchito>() {
        @Override
        public Peluchito createFromParcel(Parcel in) {
            return new Peluchito(in);
        }

        @Override
        public Peluchito[] newArray(int size) {
            return new Peluchito[size];
        }
    };
}

