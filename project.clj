(defproject clojucv "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [stencil "0.3.3"]
                 [ring/ring-devel "1.2.1"]
                 [ring/ring-core "1.2.1"]
                 [http-kit "2.1.16"]
                 [cheshire "5.3.1"]
                 [clavatar "0.2.1"]
                 [twitter-api "0.7.5"]]
  :main app
  :profiles
  {:dev {:dependencies [
                        [ring-mock "0.1.5"]
                        [javax.servlet/servlet-api "2.5"]
                        ]}})
