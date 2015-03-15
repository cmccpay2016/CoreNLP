package edu.stanford.nlp.hcoref;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import edu.stanford.nlp.hcoref.data.Dictionaries.MentionType;
import edu.stanford.nlp.hcoref.sieve.Sieve.ClassifierType;
import edu.stanford.nlp.util.Generics;
import edu.stanford.nlp.util.PropertiesUtils;


public class CorefProperties {
  
  public enum CorefInputType { RAW, CONLL, ACE, MUC };
  public enum MentionDetectionType { RULE, HYBRID, DEPENDENCY };
  
  // general 
  public static final String LANG_PROP = "hcoref.language";
  public static final String SIEVES_PROP = "hcoref.sieves";
  public static final String ALLOW_REPARSING_PROP = "hcoref.allowReparsing";
  public static final String SCORE_PROP = "hcoref.doScore";
  public static final String PARSER_PROP = "hcoref.useConstituencyTree";
  public static final String THREADS_PROP = "hcoref.threadCount";
  public static final String INPUT_TYPE_PROP = "hcoref.input.type";
  public static final String POSTPROCESSING_PROP = "hcoref.postprocessing";
  public static final String MD_TYPE_PROP = "hcoref.md.type";
  public static final String USE_SINGLETON_PREDICTOR_PROP = "hcoref.useSingletonPredictor";
  public static final String SEED_PROP = "hcoref.seed";
  public static final String CONLL_AUTO_PROP = "hcoref.conll.auto";
  public static final String MD_TRAIN_PROP = "hcoref.mdTrain";    // train MD classifier
  public static final String USE_SEMANTICS_PROP = "hcoref.useSemantics";    // load semantics if true
  public static final String CURRENT_SIEVE_FOR_TRAIN_PROP = "hcoref.currentSieveForTrain";
  public static final String STORE_TRAINDATA_PROP = "hcoref.storeTrainData";
//  public static final String CURRENT_SIEVE_PROP = "hcoref.currentSieve";
  
  // logging & system check & analysis
  public static final String DEBUG_PROP = "hcoref.debug";
  public static final String LOG_PROP = "hcoref.logFile";
  public static final String TIMER_PROP = "hcoref.checkTime";
  public static final String MEMORY_PROP = "hcoref.checkMemory";
  public static final String PRINT_MDLOG_PROP = "hcoref.print.md.log";
  public static final String CALCULATE_IMPORTANCE_PROP = "hcoref.calculateFeatureImportance";
  public static final String DO_ANALYSIS_PROP = "hcoref.analysis.doAnalysis";
  public static final String ANALYSIS_SKIP_MTYPE_PROP = "hcoref.analysis.skip.mType";
  public static final String ANALYSIS_SKIP_ATYPE_PROP = "hcoref.analysis.skip.aType";
  
  // data & io
  public static final String STATES_PROP = "hcoref.states";
  public static final String DEMONYM_PROP = "hcoref.demonym";
  public static final String ANIMATE_PROP = "hcoref.animate";
  public static final String INANIMATE_PROP = "hcoref.inanimate";
  public static final String MALE_PROP = "hcoref.male";
  public static final String NEUTRAL_PROP = "hcoref.neutral";
  public static final String FEMALE_PROP = "hcoref.female";
  public static final String PLURAL_PROP = "hcoref.plural";
  public static final String SINGULAR_PROP = "hcoref.singular";
  public static final String GENDER_NUMBER_PROP = "hcoref.big.gender.number";
  public static final String COUNTRIES_PROP = "hcoref.countries";
  public static final String STATES_PROVINCES_PROP = "hcoref.states.provinces";
  public static final String DICT_LIST_PROP = "hcoref.dictlist";
  public static final String DICT_PMI_PROP = "hcoref.dictpmi";
  public static final String SIGNATURES_PROP = "hcoref.signatures";
  public static final String LOAD_WORD_EMBEDDING_PROP = "hcoref.loadWordEmbedding";
  public static final String WORD2VEC_PROP = "hcoref.path.word2vec";
  public static final String WORD2VEC_SERIALIZED_PROP = "hcoref.path.word2vecSerialized";

  public static final String PATH_SCORER_PROP = "hcoref.path.scorer.conll";

  public static final String PATH_INPUT_PROP = "hcoref.path.input";
  public static final String PATH_OUTPUT_PROP = "hcoref.path.output";

  public static final String PATH_TRAIN_PROP = "hcoref.path.traindata";
  public static final String PATH_EVAL_PROP = "hcoref.path.evaldata";

  public static final String PATH_SERIALIZED_PROP = "hcoref.path.serialized";

  // models
  public static final String PATH_SINGLETON_PREDICTOR_PROP = "hcoref.path.singletonPredictor";
  public static final String PATH_MODEL_PROP = "hcoref.SIEVENAME.model";
  
  
  
  // sieve option
  public static final String CLASSIFIER_TYPE_PROP = "hcoref.SIEVENAME.classifierType";
  public static final String NUM_TREE_PROP = "hcoref.SIEVENAME.numTrees";
  public static final String NUM_FEATURES_PROP = "hcoref.SIEVENAME.numFeatures";
  public static final String TREE_DEPTH_PROP = "hcoref.SIEVENAME.treeDepth";
  public static final String MAX_SENT_DIST_PROP = "hcoref.SIEVENAME.maxSentDist";
  public static final String MTYPE_PROP = "hcoref.SIEVENAME.mType";
  public static final String ATYPE_PROP = "hcoref.SIEVENAME.aType";
  public static final String DOWNSAMPLE_RATE_PROP = "hcoref.SIEVENAME.downsamplingRate";
  public static final String THRES_FEATURECOUNT_PROP = "hcoref.SIEVENAME.thresFeatureCount";
  public static final String FEATURE_SELECTION_PROP = "hcoref.SIEVENAME.featureSelection";
  public static final String THRES_MERGE_PROP = "hcoref.SIEVENAME.merge.thres";
  public static final String THRES_FEATURE_SELECTION_PROP = "hcoref.SIEVENAME.pmi.thres";
  
  // features
  public static final String USE_BASIC_FEATURES_PROP = "hcoref.SIEVENAME.useBasicFeatures";
  public static final String COMBINE_OBJECTROLE_PROP = "hcoref.SIEVENAME.combineObjectRole";
  public static final String USE_MD_FEATURES_PROP = "hcoref.SIEVENAME.useMentionDetectionFeatures";
  public static final String USE_DCOREFRULE_FEATURES_PROP = "hcoref.SIEVENAME.useDcorefRuleFeatures";
  public static final String USE_POS_FEATURES_PROP = "hcoref.SIEVENAME.usePOSFeatures";
  public static final String USE_LEXICAL_FEATURES_PROP = "hcoref.SIEVENAME.useLexicalFeatures";
  public static final String USE_WORD_EMBEDDING_FEATURES_PROP = "hcoref.SIEVENAME.useWordEmbeddingFeatures";

  public static final Locale LANGUAGE_DEFAULT = Locale.ENGLISH;
  public static final int MONITOR_DIST_CMD_FINISHED_WAIT_MILLIS = 60000;
  
  
  /** if true, use truecase annotator */
  public static final boolean USE_TRUECASE = false;

  /** if true, use gold speaker tags */
  public static final boolean USE_GOLD_SPEAKER_TAGS = true;

  /** if false, use Stanford NER to predict NE labels */
  public static final boolean USE_GOLD_NE = true;

  /** if false, use Stanford parse to parse */
  public static final boolean USE_GOLD_PARSES = true;

  /** if false, use Stanford tagger to tag */
  public static final boolean USE_GOLD_POS = true;

  /** if false, use mention prediction */
  public static final boolean USE_GOLD_MENTIONS = false;

  /** if true, use given mention boundaries */
  public static final boolean USE_GOLD_MENTION_BOUNDARIES = false;

  /** if true, remove appositives, predicate nominatives in post processing */
  public static final boolean REMOVE_APPOSITION_PREDICATENOMINATIVES = true;

  /** if true, remove singletons in post processing */
  public static final boolean REMOVE_SINGLETONS = true;

  /** if true, read *auto_conll, if false, read *gold_conll */
  public static final boolean USE_CONLL_AUTO = true;

  /** if true, print in conll output format */
  public static final boolean PRINT_CONLL_OUTPUT = false;

  /** Whether or not the RuleBasedCorefMentionFinder can reparse a phrase to find its head */
  public static final boolean ALLOW_REPARSING = true;
  
  // current list of dcoref sieves
  private static final Set<String> dcorefSieveNames = new HashSet<String>(Arrays.asList("MarkRole", "DiscourseMatch", 
      "ExactStringMatch", "RelaxedExactStringMatch", "PreciseConstructs", "StrictHeadMatch1", 
      "StrictHeadMatch2", "StrictHeadMatch3", "StrictHeadMatch4", "RelaxedHeadMatch", "PronounMatch", "SpeakerMatch",
      "ChineseHeadMatch"));
  
  public static boolean doScore(Properties props) {
    return PropertiesUtils.getBool(props, SCORE_PROP, false);
  }
  public static boolean checkTime(Properties props) {
    return PropertiesUtils.getBool(props, TIMER_PROP, false);
  }
  public static boolean checkMemory(Properties props) {
    return PropertiesUtils.getBool(props, MEMORY_PROP, false);
  }
  public static boolean useConstituencyTree(Properties props) {
    return PropertiesUtils.getBool(props, PARSER_PROP, false);
  }
  
  /** Input data for CorefDocMaker. It is traindata for training, or testdata for evaluation */ 
  public static String getPathInput(Properties props) {
    return PropertiesUtils.getString(props, PATH_INPUT_PROP, null);
  }
  public static String getPathOutput(Properties props) {
    return PropertiesUtils.getString(props, PATH_OUTPUT_PROP, "/home/heeyoung/log-hcoref/conlloutput/");
  }
  public static String getPathTrainData(Properties props) {
    return PropertiesUtils.getString(props, PATH_TRAIN_PROP, "/scr/nlp/data/conll-2012/v4/data/train/data/english/annotations/");
  }
  public static String getPathEvalData(Properties props) {
    return PropertiesUtils.getString(props, PATH_EVAL_PROP, "/scr/nlp/data/conll-2012/v9/data/test/data/english/annotations");
  }
  public static int getThreadCounts(Properties props) {
    return PropertiesUtils.getInt(props, THREADS_PROP, Runtime.getRuntime().availableProcessors());
  }
  public static String getPathScorer(Properties props) {
    return PropertiesUtils.getString(props, PATH_SCORER_PROP, "/scr/nlp/data/conll-2012/scorer/v8.01/scorer.pl");
  }
  public static CorefInputType getInputType(Properties props) {
    String inputType = PropertiesUtils.getString(props, INPUT_TYPE_PROP, "raw");
    return CorefInputType.valueOf(inputType.toUpperCase());
  }
  public static Locale getLanguage(Properties props) {
    String lang = PropertiesUtils.getString(props, LANG_PROP, "en");
    if(lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("english")) return Locale.ENGLISH;
    else if(lang.equalsIgnoreCase("zh") || lang.equalsIgnoreCase("chinese")) return Locale.CHINESE;
    else throw new RuntimeException("unsupported language");
  }
  public static boolean printMDLog(Properties props) {
    return PropertiesUtils.getBool(props, PRINT_MDLOG_PROP, false);
  }
  public static boolean doPostProcessing(Properties props) {
    return PropertiesUtils.getBool(props, POSTPROCESSING_PROP, false);
  }
  
  /** if true, use conll auto files, else use conll gold files */
  public static boolean useCoNLLAuto(Properties props) {
    return PropertiesUtils.getBool(props, CONLL_AUTO_PROP, true);
  }
  public static MentionDetectionType getMDType(Properties props) {
    String type = PropertiesUtils.getString(props, MD_TYPE_PROP, "RULE");
    if(type.equalsIgnoreCase("dep")) type = "DEPENDENCY";
    return MentionDetectionType.valueOf(type.toUpperCase());
  }
  public static boolean useSingletonPredictor(Properties props) {
    return PropertiesUtils.getBool(props, USE_SINGLETON_PREDICTOR_PROP, false);
  }
  public static String getPathSingletonPredictor(Properties props) {
    return PropertiesUtils.getString(props, PATH_SINGLETON_PREDICTOR_PROP, "edu/stanford/nlp/models/dcoref/singleton.predictor.ser");
  }
  public static String getPathModel(Properties props, String sievename) {
    return new File(props.getProperty(PATH_SERIALIZED_PROP),
        props.getProperty(PATH_MODEL_PROP.replace("SIEVENAME", sievename), "TODO")).getAbsolutePath();
  }
  public static boolean debug(Properties props) {
    return PropertiesUtils.getBool(props, DEBUG_PROP, false);
  }
  
  public static ClassifierType getClassifierType(Properties props, String sievename) {
    if(dcorefSieveNames.contains(sievename)) return ClassifierType.RULE;
    if(sievename.toLowerCase().endsWith("-rf")) return ClassifierType.RF;
    if(sievename.toLowerCase().endsWith("-oracle")) return ClassifierType.ORACLE;
    String classifierType = PropertiesUtils.getString(props, CLASSIFIER_TYPE_PROP.replace("SIEVENAME", sievename), null);
    return ClassifierType.valueOf(classifierType);
  }
  public static double getMergeThreshold(Properties props, String sievename) {
    String key = THRES_MERGE_PROP.replace("SIEVENAME", sievename);
    return PropertiesUtils.getDouble(props, key, 0.3);
  }
  public static void setMergeThreshold(Properties props, String sievename, double value) {
    String key = THRES_MERGE_PROP.replace("SIEVENAME", sievename);
    props.setProperty(key, String.valueOf(value));
  }
  
  public static int getNumTrees(Properties props, String sievename) {
    return PropertiesUtils.getInt(props, NUM_TREE_PROP.replace("SIEVENAME", sievename), 100);
  }
  public static int getSeed(Properties props) {
    return PropertiesUtils.getInt(props, SEED_PROP, 1);
  }
  public static int getNumFeatures(Properties props, String sievename) {
    return PropertiesUtils.getInt(props, NUM_FEATURES_PROP.replace("SIEVENAME", sievename), 30);
  }
  public static int getTreeDepth(Properties props, String sievename) {
    return PropertiesUtils.getInt(props, TREE_DEPTH_PROP.replace("SIEVENAME", sievename), 0);
  }
  public static boolean calculateFeatureImportance(Properties props) {
    return PropertiesUtils.getBool(props, CALCULATE_IMPORTANCE_PROP, false);
  }
  public static int getMaxSentDistForSieve(Properties props, String sievename) {
    return PropertiesUtils.getInt(props, MAX_SENT_DIST_PROP.replace("SIEVENAME", sievename), 1000);
  }
  public static Set<MentionType> getMentionType(Properties props, String sievename) {
    return getMentionTypes(props, MTYPE_PROP.replace("SIEVENAME", sievename));
  }
  public static Set<MentionType> getAntecedentType(Properties props, String sievename) {
    return getMentionTypes(props, ATYPE_PROP.replace("SIEVENAME", sievename));
  }
  
  private static Set<MentionType> getMentionTypes(Properties props, String propKey) {
    if(!props.containsKey(propKey) || props.getProperty(propKey).equalsIgnoreCase("all")){
      return new HashSet<MentionType>(Arrays.asList(MentionType.values()));
    }

    Set<MentionType> types = new HashSet<MentionType>();
    for(String type : props.getProperty(propKey).trim().split(",\\s*")) {
      if(type.toLowerCase().matches("i|you|we|they|it|she|he")) type = "PRONOMINAL";
      types.add(MentionType.valueOf(type));
    }
    return types;
  }
  public static double getDownsamplingRate(Properties props, String sievename) {
    return PropertiesUtils.getDouble(props, DOWNSAMPLE_RATE_PROP.replace("SIEVENAME", sievename), 1);
  }
  public static int getFeatureCountThreshold(Properties props, String sievename) {
    return PropertiesUtils.getInt(props, THRES_FEATURECOUNT_PROP.replace("SIEVENAME", sievename), 20);
  }
  public static boolean useBasicFeatures(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_BASIC_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean combineObjectRoles(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, COMBINE_OBJECTROLE_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean useMentionDetectionFeatures(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_MD_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean useDcorefRules(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_DCOREFRULE_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean usePOSFeatures(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_POS_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean useLexicalFeatures(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_LEXICAL_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  public static boolean useWordEmbedding(Properties props, String sievename) {
    return PropertiesUtils.getBool(props, USE_WORD_EMBEDDING_FEATURES_PROP.replace("SIEVENAME", sievename), true);
  }
  
  private static Set<String> getMentionTypeStr(Properties props, String sievename, String whichMention) {
    Set<String> strs = Generics.newHashSet();
    String propKey = whichMention;
    if (!props.containsKey(propKey)) {
      String prefix = "hcoref." + sievename + ".";
      propKey = prefix + propKey;
    }
    if(props.containsKey(propKey)) strs.addAll(Arrays.asList(props.getProperty(propKey).split(",")));
    return strs;
  }
  public static Set<String> getMentionTypeStr(Properties props, String sievename) {
    return getMentionTypeStr(props, sievename, "mType");
  }
  public static Set<String> getAntecedentTypeStr(Properties props, String sievename) {
    return getMentionTypeStr(props, sievename, "aType");
  }
  public static String getSieves(Properties props) {
    return PropertiesUtils.getString(props, SIEVES_PROP, "SpeakerMatch,PreciseConstructs,pp-rf,cc-rf,pc-rf,ll-rf,pr-rf");
  }
  public static String getPathSerialized(Properties props) {
    return props.getProperty(PATH_SERIALIZED_PROP);
  }
  public static boolean doPMIFeatureSelection(Properties props, String sievename) {
    return PropertiesUtils.getString(props, FEATURE_SELECTION_PROP.replace("SIEVENAME", sievename), "pmi").equalsIgnoreCase("pmi");
  }
  public static double getPMIThres(Properties props, String sievename) {
    return PropertiesUtils.getDouble(props, THRES_FEATURE_SELECTION_PROP.replace("SIEVENAME", sievename), 0.0001);
  }
  public static boolean doAnalysis(Properties props) {
    return PropertiesUtils.getBool(props, DO_ANALYSIS_PROP, false);
  }
  public static String getSkipMentionType(Properties props) {
    return PropertiesUtils.getString(props, ANALYSIS_SKIP_MTYPE_PROP, null);
  }
  public static String getSkipAntecedentType(Properties props) {
    return PropertiesUtils.getString(props, ANALYSIS_SKIP_ATYPE_PROP, null);
  }
  public static boolean useSemantics(Properties props) {
    return PropertiesUtils.getBool(props, USE_SEMANTICS_PROP, true);
  }
  public static String getPathSerializedWordVectors(Properties props) {
    return PropertiesUtils.getString(props, WORD2VEC_SERIALIZED_PROP, "/220/cleanup/vector.ser");
  }
  public static String getCurrentSieveForTrain(Properties props) {
    return PropertiesUtils.getString(props, CURRENT_SIEVE_FOR_TRAIN_PROP, null);
  }
//  public static String getCurrentSieve(Properties props) {
//    return PropertiesUtils.getString(props, CURRENT_SIEVE_PROP, null);
//  }
  public static boolean loadWordEmbedding(Properties props) {
    return PropertiesUtils.getBool(props, LOAD_WORD_EMBEDDING_PROP, true);
  }
  public static String getPathWord2Vec(Properties props) {
    return PropertiesUtils.getString(props, WORD2VEC_PROP, null);
  }
  public static boolean storeTrainData(Properties props) {
    return PropertiesUtils.getBool(props, STORE_TRAINDATA_PROP, false);
  }
  
  public static boolean allowReparsing(Properties props) {
    return PropertiesUtils.getBool(props, ALLOW_REPARSING_PROP, true);
  }
}
