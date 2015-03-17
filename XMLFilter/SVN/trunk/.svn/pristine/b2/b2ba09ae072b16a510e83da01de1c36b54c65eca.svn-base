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

/**
 * Classes interested in events from a ModelCustomer should implement this class and add themselves as a listener to ModelCustomer
 * @author tom
 *
 */
public interface ModelCustomerListener {
    
    /**
     * Listener implementations should return true iff they approve of this brand as a purchase.
     * All listeners must approve for the choice to be accepted
     * @param brand
     * @return
     */ 
    public boolean approve(String brand);
    
    public void message(String message);
}
