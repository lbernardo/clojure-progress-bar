(ns org.clojars.lbernardo.progress-bar-test
  (:require [clojure.test :refer :all]
            [org.clojars.lbernardo.progress-bar :refer :all]))



(deftest test-progress-bar
  (let [bar (progress-bar 100)]
    (is (= (:total @bar) 100))
    (is (= (:progress @bar) 0))
    (is (= (:done? @bar) false))))


(deftest test-increment
  (let [bar (progress-bar 100)]
    (increment bar)
    (is (= (:progress @bar) 1))
    (increment bar 9)
    (is (= (:progress @bar) 10))
    (increment bar 90)
    (is (= (:progress @bar) 100))
    (is (= (:done? @bar) true))))

(deftest test-done
  (let [bar (progress-bar 100)]
    (done bar)
    (is (= (:done? @bar) true))
    (is (= (is-done? bar) true))))

(deftest test-increment-when-done
  (let [bar (progress-bar 100)]
    (done bar)
    (increment bar)
    (is (= (:progress @bar) 1))))