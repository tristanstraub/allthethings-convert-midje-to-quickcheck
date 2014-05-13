(ns io.allthethings.blog.convert-midje-to-quickcheck-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [io.allthethings.midje-quickcheck :refer :all]
            [io.allthethings.blog.convert-midje-to-quickcheck :refer :all]
            [clojure.test.check.generators :as gen]))

(fact "We can find the greatest common divisor of two positive integers"
  (gcd 24 18) => 6)

(defn gcd? [a b gcd]
  (= gcd
     (apply max
            (filter
             (fn [x] (and (= 0 (mod a x))
                          (= 0 (mod b x))))
             (range 1 (+ 1 (min a b)))))))

(fact-quickcheck "We can find the greatest common divisor of two positive integers"
  [a (gen/such-that #(< 0 %1) gen/pos-int) b (gen/such-that #(< 0 %1) gen/pos-int)]
  (gcd a b) => #(gcd? a b %1))
