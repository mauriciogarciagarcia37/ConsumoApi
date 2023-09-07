package com.example.practicaconsumoapi.Entidades

import com.example.practicaconsumoapi.Entidades.Dob
import com.example.practicaconsumoapi.Entidades.Id
import com.example.practicaconsumoapi.Entidades.Location
import com.example.practicaconsumoapi.Entidades.Login
import com.example.practicaconsumoapi.Entidades.Name
import com.example.practicaconsumoapi.Entidades.Picture
import com.example.practicaconsumoapi.Entidades.Registered

data class Result(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)