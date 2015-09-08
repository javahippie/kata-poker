(ns kata-poker.core-test
  (:require [clojure.test :refer :all]
            [kata-poker.core :refer :all]))

(deftest test-compare-hands-1
  (testing "Comparing two single cards"
    (let [card-1 "2S"
          card-2 "3D"
          result (higher-card card-1 card-2)]
    (is (neg? result)))))

(deftest test-compare-hands-2
  (testing "Comparing two single cards"
    (let [card-1 "8S"
          card-2 "3D"
          result (higher-card card-1 card-2)]
    (is (pos? result)))))


(deftest test-compare-hands-3
  (testing "Comparing two single cards"
    (let [card-1 "2S"
          card-2 "2S"
          result (higher-card card-1 card-2)]
    (is (= result 0)))))

(deftest test-compare-hands-4
  (testing "Comparing two single cards"
    (let [card-1 "JS"
          card-2 "TD"
          result (higher-card card-1 card-2)]
    (is (pos? result)))))


(deftest test-compare-hands-5
  (testing "Comparing two single cards"
    (let [card-1 "QS"
          card-2 "QD"
          result (higher-card card-1 card-2)]
    (is (= result 0)))))

(deftest test-compare-hands-6
  (testing "Comparing two single cards"
    (let [card-1 "QS"
          card-2 "KD"
          result (higher-card card-1 card-2)]
    (is (neg? result)))))
