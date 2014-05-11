(ns io.allthethings.midje-quickcheck
  (:require [clojure.test.check]
            [clojure.test.check.properties]
            [midje.sweet]))

(declare show-result)

(defmacro fact-quickcheck [description props & rest]
  `(~show-result ~description 
                 (clojure.test.check/quick-check
                  100 
                  (clojure.test.check.properties/for-all
                   ~props 
                   (midje.sweet/fact ~description ~@rest)))))

(defn show-result [description result]
  (when-not (:result result)
    (println (str "\"" description "\"") "\n\t" result)))

