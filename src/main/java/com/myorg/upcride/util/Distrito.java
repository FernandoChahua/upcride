package com.myorg.upcride.util;

import java.util.Arrays;
import java.util.List;

public class Distrito {
    String[] distritos = {"Callao", "Bellavista", "Carmen de la Lengua", "La Perla",
            "La Punta", "Mi Perú", "Ventanilla", "Lima", "Ancón", "Ate", "Barranco", "Bre�a",
            "Carabayllo", "Cieneguilla", "Chaclacayo", "Chorrillos", "Comas", "El Agustino",
            "Independencia", "Jesús María", "La Molina", "La Victoria", "Lince", "Los Olivos",
            "Lurigancho", "Lurín", "Magdalena del Mar", "Miraflores", "Pachacámac", "Pucusana",
            "Publo Libre", "Puente Piedra", "Punta Hermosa", "Punta Negra", "Rímac", "San Bartolo",
            "San Borja", "San Isidro", "San Juan de Lurigancho", "San Juan de Miraflores", "Sa Luis",
            "San Martín de Porres", "San Miguel", "Santa Anita", "Santa María del Mar", "Santa Rosa",
            "Santiago de Surco", "Surquillo", "Villa El Salvador", "Villa María del Triunfo"};
    List<String> arrDistritos;
    public Distrito(){
        arrDistritos = Arrays.asList(distritos);
    }

    public List<String> getDistritos(){
        return arrDistritos;
    }
}
