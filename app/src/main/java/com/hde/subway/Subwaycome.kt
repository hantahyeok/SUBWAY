package com.hde.subway

data class Subwaycome(var realtimeStationArrival : element)
data class element(var row : List<row>)
data class row(var subwayId : String, var trainLineNm : String, var subwayHeading : String,
               var barvlDt : String, var bstatnNm : String, var recptnDt : String, var arvlMsg : String,
               var arvlMsg2 : String, var arvlMsg3 : String)
