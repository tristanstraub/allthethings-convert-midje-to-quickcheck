(defproject convert-midje-to-quickcheck "0.1.0"
  :description "Example to show how a midje test is converted into a quickcheck test"

  :url "https://github.com/tristanstraub/allthethings-convert-midje-to-quickcheck"

  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}

  :plugins [[lein-midje "3.0.0"]]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [midje "1.6.3"]
                 [org.clojure/test.check "0.5.7"]])
