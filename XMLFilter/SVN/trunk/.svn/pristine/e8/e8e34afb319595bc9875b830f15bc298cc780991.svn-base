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
package jasdl.ia.logging;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.logging.Level;

/**
 * @author Tom Klapiscak
 * 
 */
public class log extends jason.stdlib.print {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        Level level = Level.parse(args[0].toString().toUpperCase());

        Term[] sargs = new Term[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            sargs[i - 1] = args[i];
        }

        String sout = level.toString() + ": " + argsToString(sargs);

        if (ts != null && level.intValue() <= ts.getSettings().logLevel().intValue()) {
            ts.getLogger().log(level, sout);
        } else {
            System.out.print(sout + getNewLine());
        }

        return true;
    }

}
