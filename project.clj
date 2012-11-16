(defproject clj-easygoog "1.0.0-SNAPSHOT"
  :description "Simple Google+ API Access"
  :dependencies [[org.clojure/clojure "1.3.0"]
                [com.google.api-client/google-api-client "1.12.0-beta"]
				[com.google.http-client/google-http-client-jackson2 "1.12.0-beta"]
                [com.google.apis/google-api-services-plus "v1-rev37-1.12.0-beta"]]
  :repositories {"google api services" "http://google-api-client-libraries.appspot.com/mavenrepo"}
  :main clj-easygoog.core)
