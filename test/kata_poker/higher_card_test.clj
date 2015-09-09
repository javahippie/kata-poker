(ns kata-poker.higher-card-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-higher-card-1
  (testing "Comparing two single cards, first card smaller"
    (let [card-1 "2S"
          card-2 "3D"
          result (higher-card card-1 card-2)]
    (is (neg? result)))))

(deftest test-higher-card-2
  (testing "Comparing two single cards, first card higher"
    (let [card-1 "8S"
          card-2 "3D"
          result (higher-card card-1 card-2)]
    (is (pos? result)))))


(deftest test-higher-card-3
  (testing "Comparing two single cards, cards equal"
    (let [card-1 "2S"
          card-2 "2S"
          result (higher-card card-1 card-2)]
    (is (= result 0)))))
