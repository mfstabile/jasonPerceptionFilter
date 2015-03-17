package jasdl;

import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.DecapitaliseMappingStrategy;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jason.asSyntax.Atom;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class JASDLParams {
    /**
     * Namespace of the JASDL configuration ontology
     */
    public static String JASDL_OWL_NS = "http://www.dur.ac.uk/t.g.klapiscak/onts/owl2mas/jasdl.owl#";
    
    public static float DEFAULT_TRUST_RATING = 0;
    
    public static String JASDL_TG_CAUSE_RETAIN_ANNOTS = "JASDL_TG_CAUSE_RETAIN_ANNOTS";
    
    public static String JASDL_TG_CAUSE = "JASDL_TG_CAUSE";
    
    /**
     * Functor of the structure containing the ontology label which maps to the ontology a SE-Literal refers to
     */
    public static String ONTOLOGY_ANNOTATION_FUNCTOR = "o";

    /**
     * SE-Message Protocol Annotation
     */
    public static String NAMED_ANNOTATION_FUNCTOR = "named";

    /**
     * SE-Message Protocol Annotation
     */
    public static String ANON_ANNOTATION_FUNCTOR = "anon";

    /**
     * SE-Message Protocol Annotation
     */
    public static String I_ANNOTATION_FUNCTOR = "i";

    /**
     * SE-Message Protocol Annotation
     */
    public static Atom NO_INDIVIDUAL_MAPPING = new Atom("none");

    /**
     * SE-Message Protocol Annotation
     */
    public static String ALL_DIFFERENT_ANNOTATION_FUNCTOR = "all_different";

    /**
     * When set Bebops library is used for belief revision. Otherwise Pellet's tracing functionality is used.
     * The latter, although faster, has proved buggy so is likely to be deprecated
     */
    public static boolean USE_BEBOPS_BELIEF_REVISION = true;

    /**
     * If set, results of various operations on SE-Literals are cached for later usage.
     * Tentatively, yes. May cause problems however.
     */
    public static boolean USE_SELITERAL_CACHING = true;

    /**
     * The ontology label mapped to http://www.w3.org/2002/07/owl, used by aliases referring to owl:thing or owl:nothing
     */
    public static Atom OWL_NAMESPACE_LABEL = new Atom("owl");

    /**
     * A singleton alias mapped to the universal owl:thing concept
     */
    public static Alias OWL_THING = new Alias(new Atom("thing"), OWL_NAMESPACE_LABEL);

    /**
     * A singleton alias mapped to the universal owl:nothing concept
     */
    public static Alias OWL_NOTHING = new Alias(new Atom("nothing"), OWL_NAMESPACE_LABEL);

    public static Atom OWL_ALL_DIFFERENT_FUNCTOR = new Atom("all_different");

    /**
     * JASDL .mas2j configuration parameter name component.
     * Prefixed to the start of all JASDL .mas2j configuration parameter names.
     */
    public static String MAS2J_PREFIX = "jasdl";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_ONTOLOGIES = "_ontologies";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_URI = "_uri";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_MAPPING_STRATEGIES = "_mapping_strategies";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_MAPPING_MANUAL = "_mapping_manual";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_TRUSTRATING = "_trustRating";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_KNOWNAGENTS = "_knownAgents";

    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_USEBELIEFREVISION = "_useBeliefRevision";

    /**
     * JASDL .mas2j configuration parameter name component.
     */
    public static String MAS2J_USEANNOTATIONGATHERING = "_useAnnotationGathering";

    /**
     * JASDL .mas2j configuration parameter name component.
     */
    public static String MAS2J_USECONTRACTION = "_useContraction";
    
    /**
     * JASDL .mas2j configuration parameter name component. 
     */
    public static String MAS2J_REASONERCLASS = "_reasonerClass";

    /**
     * The default set of mapping strategies agents use as *their* default - i.e. those applied to run-time instantiated ontologies or 
     * configuration time specified ontologies with no mapping strategies setting supplied.
     */
    public static List<MappingStrategy> DEFAULT_MAPPING_STRATEGIES = Arrays.asList(new MappingStrategy[] { new DecapitaliseMappingStrategy() });

    /**
     * The reasoner class an agent will use if none specified in .mas2j file.
     */
    public static String DEFAULT_REASONER_CLASS = "org.mindswap.pellet.owlapi.Reasoner";

    /**
     * Determines whether an agent that does not specify otherwise in the .mas2j file will make use of DL-based belief revision.
     */
    public static boolean DEFAULT_USEBELIEFREVISION = false;

    /**
     * Determines whether an agent that does not specify otherwise in the .mas2j file will make use of DL-based belief annotation gathering.
     */
    public static boolean DEFAULT_USEANNOTATIONGATHERING = false;
    
    /**
     * Determines whether agents will use contraction for belief base removal.
     */
    public static boolean DEFAULT_USECONTRACTION = false;

    public static URI OWL_URI = URI.create("http://www.w3.org/2002/07/owl");

    /**
     * List of reserved ontology labels. Currently:
     * <ul>
     *  <li> "default" - allows jasdl_default_mapping_strategies to be conveniently used to define the default mapping strategies performed
     *      by this agent on unknown incoming ontologies and predefined ontologies lacking mapping strategy definition</li>
     * <li> "self" - refers to the "personal" ontology used by this agent to store axioms referencing run-time defined classes and individuals </li>
     * <li> "owl" - refers to http://www.w3.org/2002/07/owl for mapping owl:thing and owl:nothing</li>
     * </ul>
     */
    public static List<Atom> RESERVED_ONTOLOGY_LABELS = Arrays.asList(new Atom[] { new Atom("default"), new Atom("self"), new Atom("owl") });

    /**
     * The delimiter used by JASDL for configuration parameters with multiple values.
     */
    public static String DELIM = ",";

    public static int DOMAIN = 0;

    public static int RANGE = 1;

    /**
     * Prefix to use when creating unique anonymous entity aliases.
     */
    public static String ANON_ALIAS_PREFIX = "anon_alias_";

    /**
     * Prefix to use when creating unique anonymous ontology labels
     */
    public static String ANON_LABEL_PREFIX = "anon_label_";

    /**
     * Prefix to use when creating unique anonymous individual names
     */
    public static String ANONYMOUS_INDIVIDUAL_PREFIX = "instance_";
}
