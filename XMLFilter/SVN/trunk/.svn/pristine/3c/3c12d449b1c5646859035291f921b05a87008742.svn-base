/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JASDL.
 *
 *  JASDL is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JASDL is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JASDL.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package commerce.model;

import jason.runtime.Settings;

public class Product {
    public String brand;
    public String classification;
    public double RRP;
    public double weight;   
    
    public Product(String classification, String brand, double rrp, double weight) {
        super();
        this.brand = brand;
        this.classification = classification;
        this.RRP = rrp;
        this.weight = weight;
    }
    
    public Product(Settings stts){
        this.brand = stts.getUserParameter("product_brand");
        this.classification = stts.getUserParameter("product_classification");
        this.RRP = Double.parseDouble(stts.getUserParameter("product_rrp"));
        this.weight = Double.parseDouble(stts.getUserParameter("product_weight"));
    }
    
}
