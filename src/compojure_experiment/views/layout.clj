(ns compojure_experiment.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to compojure_experiment"]
     (include-css "/css/screen.css")]
    [:body body]))
