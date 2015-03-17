package jasdl.bridge.protocol;

import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLMessageContentException;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;

import java.util.List;

public class ProtocolProcessor {
    private JASDLOntologyManager jom;

    private ProtocolProcessingStrategy incomingStrategy;

    private ProtocolProcessingStrategy outgoingStrategy;

    /**
     * Sets up using default processing strategies
     *
     */
    public ProtocolProcessor(JASDLOntologyManager jom, List<MappingStrategy> mappingStrategies) {
        this.jom = jom;
        this.incomingStrategy = new IncomingProtocolProcessingStrategy(mappingStrategies);
        this.outgoingStrategy = new OutgoingProtocolProcessingStrategy(jom.getSELiteralFactory());
    }

    public ProtocolProcessor(JASDLOntologyManager jom, ProtocolProcessingStrategy incomingStrategy, ProtocolProcessingStrategy outgoingStrategy) {
        super();
        this.jom = jom;
        this.incomingStrategy = incomingStrategy;
        this.outgoingStrategy = outgoingStrategy;
    }

    public Structure processIncomingStructure(Literal struct) throws JASDLMessageContentException {
        if (struct instanceof Structure)
            return processStructure((Structure)struct, incomingStrategy);
        else
            return processStructure(new Structure(struct), incomingStrategy);
    }

    public Structure processOutgoingStructure(Literal struct) throws JASDLMessageContentException {
        if (struct instanceof Structure)
            return processStructure((Structure)struct, outgoingStrategy);
        else 
            return processStructure(new Structure(struct), outgoingStrategy);
    }

    private Structure processStructure(Structure struct, ProtocolProcessingStrategy strategy) throws JASDLMessageContentException {

        // recurse down terms and lists (for "bundled" SE-enriched content)
        if (struct.getArity() > 0) { // if we have any terms to process!
            // Process outer SE-enriched content
            if (struct.isLiteral()) { // processing strategies only apply to Literals
                // TODO: (by Jomi): shouldn't the above test be instanceof LiteralImpl? (since for jason 1.2.0 even an Atom is considered a Literal)
                Literal l = (Literal) struct;
                try {
                    struct = (Structure)strategy.process(l, jom);
                } catch (JASDLException e) {
                    e.printStackTrace();
                }
            }

            //int i=0;
            //for(Term _term : struct.getTerms()){ - mustn't use in case struct is a list       
            if (struct.isVar()) {
                struct = (Structure) ((VarTerm) struct).getValue(); // resolve struct if var
            }
            if (struct.isList()) { // special processing for lists (since we can't (or rather shouldn't)) use getTerm or setTerm)
                ListTermImpl newList = new ListTermImpl(); // a "clone"
                for (Term e : ((ListTerm) struct).getAsList()) {
                    jom.getLogger().finest("Processing " + e);
                    if (e instanceof Structure) {
                        Structure alteredTerm = (Structure) processStructure((Structure) e, strategy);
                        newList.append(alteredTerm);
                    }
                }
                return newList;
            } else { // all other structures
                for (int i = 0; i < struct.getArity(); i++) {
                    Term _term = struct.getTerm(i);
                    if (_term instanceof Structure) {
                        Structure term = (Structure) _term;
                        Structure alteredTerm = (Structure) processStructure(term, strategy);
                        struct.setTerm(i, alteredTerm); // modifies original struct
                    }
                }
            }
        }

        return struct;
    }
}
