(ns io.allthethings.blog.convert-midje-to-quickcheck-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [io.allthethings.midje-quickcheck :refer :all]
            [io.allthethings.blog.convert-midje-to-quickcheck :refer :all]
            [clojure.test.check.generators :as gen]))

(fact "We can find the greatest common divisor of two positive integers"
  (gcd 24 18) => 6)

(fact-quickcheck "We can find the greatest common divisor of two positive integers"
  [a (gen/such-that #(< 0 %1) gen/pos-int) b (gen/such-that #(< 0 %1) gen/pos-int)]
  (gcd a b) => #(and (= 0 (mod a %1))
                     (= 0 (mod b %1))))
