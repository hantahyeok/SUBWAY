package com.hde.subway

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import com.bumptech.glide.Glide
import com.hde.subway.Coordinate
import com.hde.subway.databinding.Fragment1Binding
import java.util.*

class Fragment1 : Fragment(){

    lateinit var binding: Fragment1Binding

    var xcoord = 0
    var ycoord = 0



    val gyeongchun: Map<String, Coordinate> = mapOf( "춘천" to Coordinate(0.9219F,0.0937F), "남춘천" to Coordinate(0.9219F,0.1115F), "김유정" to Coordinate(0.9219F,0.1289F), "강촌" to Coordinate(0.9219F,0.1463F),"백양리" to Coordinate(0.9220F,0.1638F),"굴봉산" to Coordinate(0.9220F,0.1813F),"가평" to Coordinate(0.9220F,0.1988F),"상천" to Coordinate(0.9220F,0.2163F),"청평" to Coordinate(0.9220F,0.2338F),"대성" to Coordinate(0.9220F,0.2513F),"마석" to Coordinate(0.9221F,0.2703F),"천마" to Coordinate(0.9166F,0.2875F),"평내호평" to Coordinate(0.9022F,0.2968F),"금곡" to Coordinate(0.8866F,0.2979F),"사릉" to Coordinate(0.8866F,0.2979F),"퇴계원" to Coordinate(0.8556F,0.2980F),"별내" to Coordinate(0.8399F,0.2979F),"갈매" to Coordinate(0.8244F,0.2977F),"신내" to Coordinate(0.8086F,0.2950F),"망우" to Coordinate(0.7867F,0.2993F),"상봉" to Coordinate(0.7688F,0.3016F),"중랑" to Coordinate(0.7266F,0.2990F),"회기" to Coordinate(0.6890F,0.2975F),"청량리" to Coordinate(0.6671F,0.2998F),"광운대" to Coordinate(0.7325F,0.2323F),)
    val gyeoncenter: Map<String, Coordinate> = mapOf("지평" to Coordinate(0.9223F,0.3404F),"용문" to Coordinate(0.9219F,0.3607F),"원덕" to Coordinate(0.9221F,0.3802F),"양평" to Coordinate(0.9221F,0.4003F),"오빈" to Coordinate(0.9194F,0.4217F),"아신" to Coordinate(0.9072F,0.4356F),"" to Coordinate(0.9070F,0.4358F),"국수" to Coordinate(0.8904F,0.4374F),"신원" to Coordinate(0.8735F,0.4378F),"양수" to Coordinate(0.8566F,0.4374F),"운길산" to Coordinate(0.8400F,0.4377F),"팥당" to Coordinate(0.8220F,0.4356F),"도심" to Coordinate(0.8094F,0.4216F),"덕소" to Coordinate(0.8068F,0.4006F),"양정" to Coordinate(0.8066F,0.3804F),"도농" to Coordinate(0.8070F,0.3601F),"구리" to Coordinate(0.8068F,0.3403F),"양원" to Coordinate(0.8053F,0.3169F),"왕십리" to Coordinate(0.6148F,0.3385F),"응봉" to Coordinate(0.5913F,0.4197F),"옥수" to Coordinate(0.5560F,0.4650F),"한남" to Coordinate(0.5417F,0.4839F),"서빙고" to Coordinate(0.5282F,0.5002F),"이촌" to Coordinate(0.5046F,0.5055F),"용산" to Coordinate(0.4493F,0.4860F),"효창 공원앞" to Coordinate(0.4267F,0.4401F),"공덕" to Coordinate(0.4267F,0.4401F),"서강대" to Coordinate(0.3782F,0.4277F),"가좌" to Coordinate(0.3782F,0.4277F),"신촌(경의중앙선)" to Coordinate(0.3853F,0.3002F),"서울역" to Coordinate(0.4480F,0.4100F),"디지털 미디어시티" to Coordinate(0.3046F,0.3043F),"수색" to Coordinate(0.2896F,0.2794F),"화전" to Coordinate(0.2897F,0.2512F),"강매" to Coordinate(0.2893F,0.2232F),"행신" to Coordinate(0.2599F,0.2036F),"능곡" to Coordinate(0.2264F,0.2039F),"대곡" to Coordinate(0.2020F,0.1833F),"곡산" to Coordinate(0.2024F,0.1617F),"백마" to Coordinate(0.2021F,0.1457F),"풍산" to Coordinate(0.2021F,0.1298F),"일산" to Coordinate(0.2022F,0.1155F),"탄현" to Coordinate(0.1981F,0.1013F),"야당" to Coordinate(0.1888F,0.0909F),"운정" to Coordinate(0.1739F,0.0886F),"금릉" to Coordinate(0.1564F,0.0881F),"금촌" to Coordinate(0.1387F,0.0883F),"월릉" to Coordinate(0.1208F,0.0887F),"파주" to Coordinate(0.1036F,0.0883F),"문산" to Coordinate(0.0844F,0.0885F),"운천" to Coordinate(0.0657F,0.0883F),"임진강" to Coordinate(0.0478F,0.0883F))
    val incheon1: Map<String, Coordinate> = mapOf("송도 달빛축제 공원" to Coordinate(0.0883F,0.9044F),"국체 업무지구" to Coordinate(0.1069F,0.9046F),"센트럴파크" to Coordinate(0.1252F,0.9044F),"인천대 입구" to Coordinate(0.1432F,0.9042F),"지식 정보단지" to Coordinate(0.1618F,0.9045F),"테크노파크" to Coordinate(0.1773F,0.8985F),"캠퍼스타운" to Coordinate(0.1849F,0.8846F),"동막" to Coordinate(0.1861F,0.8666F),"동춘" to Coordinate(0.1860F,0.8476F),"원인재" to Coordinate(0.1857F,0.8219F),"신연수" to Coordinate(0.1859F,0.8008F),"선학" to Coordinate(0.1860F,0.7808F),"문학경기" to Coordinate(0.1864F,0.7614F),"인천터미널" to Coordinate(0.1862F,0.7414F),"예술회관" to Coordinate(0.1860F,0.7210F),"인천시청" to Coordinate(0.1859F,0.6978F),"간석오거리" to Coordinate(0.1860F,0.6802F),"부평삼거리" to Coordinate(0.1851F,0.6647F),"동수" to Coordinate(0.1782F,0.6516F),"부평" to Coordinate(0.1597F,0.6434F),"" to Coordinate(0.1350F,0.6208F),"부평시장" to Coordinate(0.1350F,0.6208F),"부평구청" to Coordinate(0.1336F,0.5707F),"갈산" to Coordinate(0.1338F,0.5368F),"작전" to Coordinate(0.1336F,0.5021F),"경인 교대입구" to Coordinate(0.1338F,0.4675F),"계산" to Coordinate(0.1337F,0.4327F),"임학" to Coordinate(0.1338F,0.3983F),"박촌" to Coordinate(0.1338F,0.3641F),"귤현" to Coordinate(0.1329F,0.3290F),"계양" to Coordinate(0.1069F,0.3088F))
    val incheon2: Map<String, Coordinate> = mapOf("운연" to Coordinate(0.2291F,0.7946F),"인천대공원" to Coordinate(0.2291F,0.7735F),"남동구청" to Coordinate(0.2291F,0.7526F),"만수" to Coordinate(0.2289F,0.7316F),"모래내시장" to Coordinate(0.2274F,0.7101F),"석천사거리" to Coordinate(0.2077F,0.7002F),"인천시청" to Coordinate(0.1861F,0.6981F),"석바위시장" to Coordinate(0.1678F,0.6999F),"시민공원" to Coordinate(0.1518F,0.7002F),"주안" to Coordinate(0.1338F,0.6980F),"주안 국가산단" to Coordinate(0.1145F,0.6934F),"가재울" to Coordinate(0.1064F,0.6751F),"인천가좌" to Coordinate(0.1064F,0.6510F),"서부 여성회관" to Coordinate(0.1066F,0.6266F),"석남" to Coordinate(0.1078F,0.5991F),"가정 중앙시장" to Coordinate(0.1067F,0.5756F),"가정" to Coordinate(0.1064F,0.5525F),"서구청" to Coordinate(0.1045F,0.5286F),"아시아드 경기장" to Coordinate(0.0940F,0.5108F),"검바위" to Coordinate(0.0843F,0.4934F),"검암" to Coordinate(0.0810F,0.4672F),"독정" to Coordinate(0.0831F,0.4435F),"완정" to Coordinate(0.0831F,0.4231F),"마전" to Coordinate(0.0825F,0.4034F),"검단사거리" to Coordinate(0.0832F,0.3837F),"왕길" to Coordinate(0.0831F,0.3635F),"검단오류" to Coordinate(0.0833F,0.3438F))
    val sinbundang: Map<String, Coordinate> = mapOf("광교" to Coordinate(0.5118F,0.7650F),"광교중앙" to Coordinate(0.5288F,0.7650F),"상현" to Coordinate(0.5458F,0.7652F),"성복" to Coordinate(0.5628F,0.7648F),"수지구청" to Coordinate(0.5795F,0.7651F),"동천" to Coordinate(0.5951F,0.7764F),"미금" to Coordinate(0.6165F,0.7905F),"정자" to Coordinate(0.6370F,0.7902F),"판교" to Coordinate(0.6635F,0.7600F),"청계산 입구" to Coordinate(0.6368F,0.7305F),"양재시민의숲" to Coordinate(0.6069F,0.7309F),"양재" to Coordinate(0.5900F,0.7007F),"강남" to Coordinate(0.5902F,0.6597F),"신논현" to Coordinate(0.5902F,0.6096F),"논현" to Coordinate(0.5867F,0.5355F),"신사" to Coordinate(0.5579F,0.5306F))
    val suinbundang: Map<String, Coordinate> = mapOf("인천" to Coordinate(0.1337F,0.7913F),"신포" to Coordinate(0.1337F,0.8138F),"숭의 " to Coordinate(0.1338F,0.8377F),"인하대" to Coordinate(0.1383F,0.8686F),"송도" to Coordinate(0.1676F,0.8725F),"연수" to Coordinate(0.1754F,0.8437F),"원인재" to Coordinate(0.1862F,0.8216F),"남동 인더스파크" to Coordinate(0.2058F,0.8222F),"호구포" to Coordinate(0.2276F,0.8219F),"인천논현" to Coordinate(0.2497F,0.8217F),"소래포구" to Coordinate(0.2714F,0.8220F),"월곶" to Coordinate(0.2901F,0.8282F),"달월" to Coordinate(0.2951F,0.8492F),"오이도" to Coordinate(0.2935F,0.8717F),"정왕" to Coordinate(0.2986F,0.8908F),"신길온천" to Coordinate(0.3084F,0.9003F),"안산" to Coordinate(0.3259F,0.9004F),"초지" to Coordinate(0.3348F,0.8889F),"고잔" to Coordinate(0.3417F,0.8705F),"중앙" to Coordinate(0.3413F,0.8500F),"한대앞" to Coordinate(0.3409F,0.8288F),"사리" to Coordinate(0.3516F,0.7986F),"야목" to Coordinate(0.3807F,0.7978F),"어천" to Coordinate(0.3918F,0.8301F),"오목천" to Coordinate(0.3918F,0.8621F),"고색" to Coordinate(0.3999F,0.8921F),"수원" to Coordinate(0.4203F,0.9016F),"매교" to Coordinate(0.4452F,0.8851F),"수원시청" to Coordinate(0.4480F,0.8676F),"매탄권선" to Coordinate(0.4482F,0.8486F),"망포" to Coordinate(0.4478F,0.8280F),"영동" to Coordinate(0.4524F,0.8073F),"청명" to Coordinate(0.4642F,0.7946F),"상갈" to Coordinate(0.4816F,0.7920F),"기흠" to Coordinate(0.5008F,0.7935F),"신갈" to Coordinate(0.5202F,0.7921F),"구성" to Coordinate(0.5398F,0.7926F),"보정" to Coordinate(0.5592F,0.7924F),"죽전" to Coordinate(0.5782F,0.7928F),"오리" to Coordinate(0.5972F,0.7925F),"수내" to Coordinate(0.6571F,0.7921F),"서현" to Coordinate(0.6775F,0.7928F),"이매" to Coordinate(0.6937F,0.7903F),"야탑" to Coordinate(0.7136F,0.7922F),"모란" to Coordinate(0.7324F,0.7939F),"태평" to Coordinate(0.7530F,0.7760F),"가천대" to Coordinate(0.7555F,0.7489F),"복정" to Coordinate(0.7570F,0.7129F),"수서" to Coordinate(0.7328F,0.6477F),"대모산 입구" to Coordinate(0.7097F,0.6797F),"개포동" to Coordinate(0.6864F,0.7073F),"구룡" to Coordinate(0.6557F,0.7077F),"도곡" to Coordinate(0.6263F,0.7029F),"한티" to Coordinate(0.6189F,0.6836F),"선릉" to Coordinate(0.6190F,0.6636F),"선정릉" to Coordinate(0.6192F,0.6125F),"강남구청" to Coordinate(0.6178F,0.4989F),"서울숲" to Coordinate(0.6192F,0.4122F),)
    val airport: Map<String, Coordinate> = mapOf("인천공항2터미널" to Coordinate(0.0800F,0.8145F),"인천공항1터미널" to Coordinate(0.0815F,0.7837F),"공항 화물청사" to Coordinate(0.0798F,0.7500F),"운서" to Coordinate(0.0798F,0.7158F),"영종" to Coordinate(0.0800F,0.6870F),"청라국제도시" to Coordinate(0.0799F,0.5195F),"검암" to Coordinate(0.0810F,0.4673F),"김포공항" to Coordinate(0.2028F,0.3028F),"마곡나루" to Coordinate(0.2476F,0.3091F),"디지털 미디어시티" to Coordinate(0.3050F,0.3042F),"공덕" to Coordinate(0.4120F,0.4336F),)
    val sillim: Map<String, Coordinate> = mapOf()
    val uijeongbu: Map<String, Coordinate> = mapOf()
    val everline: Map<String, Coordinate> = mapOf()
    val kimpogold: Map<String, Coordinate> = mapOf()
    val saheasun: Map<String, Coordinate> = mapOf()
    val gyeonggamseon: Map<String, Coordinate> = mapOf()
    val uisinseol: Map<String, Coordinate> = mapOf()
    val station1: Map<String, Coordinate> = mapOf()
    val station2: Map<String, Coordinate> = mapOf()
    val station3: Map<String, Coordinate> = mapOf()
    val station4: Map<String, Coordinate> = mapOf()
    val station5: Map<String, Coordinate> = mapOf()
    val station6: Map<String, Coordinate> = mapOf()
    val station7: Map<String, Coordinate> = mapOf()
    val station8: Map<String, Coordinate> = mapOf()
    val station9: Map<String, Coordinate> = mapOf()

    val stationcoordinate: List<Map<String,Coordinate>> = listOf(gyeongchun,gyeoncenter,incheon1,incheon2,sinbundang,suinbundang,airport,sillim,uijeongbu
        ,everline,kimpogold,saheasun,gyeonggamseon,uisinseol,station1,station2,station3,station4,station5,station6,station7,station8,station9)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        //글라이드 사용시
        //Glide.with(requireActivity()).load(R.drawable.naver_subway).into(binding.pv)

        binding.pv.maximumScale= 30.0F //6.0 적합
        binding.pv.minimumScale= 1.72F

        Handler(Looper.getMainLooper()).postDelayed({
            binding.pv.scale=5.0F
        }, 100)

        // 좌표 구하는
        binding.pv.setOnPhotoTapListener { view, x, y ->
            var myx= (x * 10000).toInt()
            var myy= (y * 10000).toInt()

            Log.i("aaa", ("$x , $y"))

            if(myx > myx-100 && myx < myx+100 && myy > myy-100 && myy < myy+100) {

                var minimum=1000000000.0
                var station=""

                var distance:Double= 50000.0

                stationcoordinate.forEach { list ->
                    list.forEach {
                        xcoord= (it.value.x * 10000).toInt()
                        ycoord= (it.value.y * 10000).toInt()

                        var xkey= (myx - xcoord).toDouble()
                        var ykey= (myy - ycoord).toDouble()

                        //사용자 터치 위치와 역사이의 거리
                        distance= Math.pow(xkey, 2.0) + Math.pow(ykey, 2.0)
                        distance=Math.sqrt(distance)

                        if( distance < minimum ){
                            minimum = distance
                            station = it.key
                        }
                    }
                }
                if(minimum < 100.0){
                    Toast.makeText(requireContext(), "$station", Toast.LENGTH_SHORT).show()
                    //클릭시 말풍선 뜨게 해야됨
                    binding.include.click.visibility=View.VISIBLE


                }else{
                    binding.include.click.visibility=View.GONE
                }
            }

        }//photoview click..

        return binding.root
    }//onCreate....

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}