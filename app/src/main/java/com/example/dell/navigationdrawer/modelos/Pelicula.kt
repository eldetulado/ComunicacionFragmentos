package com.example.dell.navigationdrawer.modelos

import android.os.Parcel
import android.os.Parcelable

class Pelicula(val nombre: String, val etiqueta: String, val descripcion: String, val stock: Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun toString(): String {
        return "Pelicula(nombre='$nombre', etiqueta='$etiqueta', descripcion='$descripcion', stock=$stock)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(etiqueta)
        parcel.writeString(descripcion)
        parcel.writeByte(if (stock) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }
}