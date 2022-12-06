package com.hde.subway

data class Subwaycome(var realtimeStationArrival : Element)
data class Element(var row : List<Row2>)
data class Row2(var subwayId : String, var trainLineNm : String, var subwayHeading : String,
                var barvlDt : String, var bstatnNm : String, var recptnDt : String, var arvlMsg : String,
                var arvlMsg2 : String, var arvlMsg3 : String)
