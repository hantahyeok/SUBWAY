package com.hde.subway

import android.content.Context
import android.content.Intent
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
    val sillim: Map<String, Coordinate> = mapOf("샛강" to Coordinate(4239F,5078F),"대방" to Coordinate(4224F,5494F),"보라매" to Coordinate(4018F,5990F),"보라매 공원" to Coordinate(3831F,6120F),"보라매 병원" to Coordinate(3825F,6289F),"당곡" to Coordinate(3828F,6433F),"신림" to Coordinate(3825F,6649F),"서원" to Coordinate(4072F,6875F),"서울대 벤처타운" to Coordinate(4369F,6890F),"관악산" to Coordinate(4659F,6884F))
    val uijeongbu: Map<String, Coordinate> = mapOf("발곡" to Coordinate(6543F,928F),"회룡" to Coordinate(6559F,1097F),"범골" to Coordinate(6505F,1254F),"경전철 의정부" to Coordinate(6401F,1339F),"의정부 시청" to Coordinate(6248F,1348F),"흥선" to Coordinate(6142F,1247F),"의정부 중앙" to Coordinate(6152F,922F),"동오" to Coordinate(6359F,814F),"새말" to Coordinate(6672F,816F),"경기도청 북부청사" to Coordinate(6977F,816F),"효자" to Coordinate(7289F,819F),"곤제" to Coordinate(7594F,816F),"어룡" to Coordinate(7896F,805F),"송산" to Coordinate(8206F,825F),"탑석" to Coordinate(8396F,1095F))
    val everline: Map<String, Coordinate> = mapOf("전대 에버랜드" to Coordinate(8706F,8664F),"둔전" to Coordinate(8405F,8659F),"보평" to Coordinate(8100F,8662F),"고진" to Coordinate(7795F,8659F),"운동장 송담대" to Coordinate(7492F,8664F),"김량장" to Coordinate(7188F,8664F),"명지대" to Coordinate(6882F,8663F),"시청 용인대" to Coordinate(6575F,8662F),"삼가" to Coordinate(6271F,8667F),"초당" to Coordinate(5970F,8667F),"동백" to Coordinate(5666F,8667F),"어정" to Coordinate(5362F,8665F),"지석" to Coordinate(5060F,8560F),"강남대" to Coordinate(5006F,8251F))
    val kimpogold: Map<String, Coordinate> = mapOf("고촌" to Coordinate(1924F,2624F),"풍무" to Coordinate(1750F,2573F),"사우" to Coordinate(1571F,2574F),"걸포북변" to Coordinate(1390F,2573F),"운양" to Coordinate(1205F,2574F),"장기" to Coordinate(1021F,2575F),"마산" to Coordinate(844F,2581F),"구래" to Coordinate(660F,2578F),"양촌" to Coordinate(478F,2578F),)
    val saheasun: Map<String, Coordinate> = mapOf("원시" to Coordinate(3755F,9047F),"시우" to Coordinate(3542F,9033F),"선부" to Coordinate(3236F,8722F),"달미" to Coordinate(3196F,8437F),"시흥능곡" to Coordinate(3202F,8129F),"시흥시청" to Coordinate(2960F,7929F),"신현" to Coordinate(2724F,7615F),"신천" to Coordinate(2724F,7216F),"시흥대야" to Coordinate(2719F,6818F),"소새울" to Coordinate(2629F,6451F),"서해" to Coordinate(2289F,6431F),)
    val gyeonggamseon: Map<String, Coordinate> = mapOf("여주" to Coordinate(8670F,8318F),"세종대왕릉" to Coordinate(8444F,8318F),"부발" to Coordinate(8216F,8317F),"이천" to Coordinate(7989F,8319F),"신둔도예촌" to Coordinate(7763F,8314F),"곤지암" to Coordinate(7526F,8321F),"초월" to Coordinate(7306F,8320F),"경기광주" to Coordinate(7072F,8309F),"삼동" to Coordinate(6942F,8155F),"성남" to Coordinate(6872F,7633F))
    val uisinseol: Map<String, Coordinate> = mapOf("신설동" to Coordinate(5900F,2953F),"보문" to Coordinate(5767F,2462F),"성신여대입구" to Coordinate(5511F,2026F),"정릉" to Coordinate(5510F,1805F),"북한산 보국문" to Coordinate(5572F,1671F),"솔샘" to Coordinate(5713F,1625F),"삼양사거리" to Coordinate(5884F,1625F),"삼양" to Coordinate(6062F,1633F),"화계" to Coordinate(6232F,1622F),"가오리" to Coordinate(6409F,1626F),"4.19민주묘지" to Coordinate(6581F,1626F),"솔밭공원" to Coordinate(6756F,1629F),"북한산우이" to Coordinate(6928F,1631F))
    val station1: Map<String, Coordinate> = mapOf("남영" to Coordinate(4497F,4592F),"시청" to Coordinate(4491F,3392F),"종각" to Coordinate(4563F,3026F),"종로3가" to Coordinate(4828F,2948F),"종로5가" to Coordinate(5045F,2940F),"동대문" to Coordinate(5253F,2924F),"동묘앞" to Coordinate(5608F,2924F),"제기동" to Coordinate(6275F,2941F),"외대앞" to Coordinate(7135F,2945F),"신이문" to Coordinate(7290F,2816F),"석계" to Coordinate(7328F,2082F),"창동" to Coordinate(7319F,1975F),"방학" to Coordinate(7326F,1666F),"도봉" to Coordinate(7327F,1383F),"도봉산" to Coordinate(7099F,1100F),"망월사" to Coordinate(6811F,1109F),"의정부" to Coordinate(6319F,1105F),"가능" to Coordinate(6027F,1108F),"녹양" to Coordinate(5765F,1098F),"양주" to Coordinate(5515F,1103F),"덕계" to Coordinate(5253F,1101F),"덕정" to Coordinate(5003F,1100F),"지행" to Coordinate(4741F,1104F),"동두천중앙" to Coordinate(4485F,1109F),"보산" to Coordinate(4226F,1110F),"동두천" to Coordinate(3971F,1111F),"소요산" to Coordinate(3712F,1102F),"광명" to Coordinate(2996F,6940F),"금전구청" to Coordinate(3096F,6651F),"독산" to Coordinate(3106F,6303F),"가산디지털단지" to Coordinate(3102F,5982F),"구로" to Coordinate(3266F,5511F),"신도림" to Coordinate(3396F,5464F),"영등포" to Coordinate(3668F,5507F),"신길" to Coordinate(3937F,5474F),"신길" to Coordinate(4474F,5370F),"서동탄" to Coordinate(4838F,8815F),"병점" to Coordinate(4669F,8994F),"세류" to Coordinate(4427F,9008F),"화서" to Coordinate(4006F,8846F),"성균관대" to Coordinate(3957F,8535F),"의왕" to Coordinate(3955F,8232F),"당정" to Coordinate(3956F,7945F),"군포" to Coordinate(3956F,7652F),"금정" to Coordinate(3956F,7333F),"명학" to Coordinate(3895F,7083F),"안양" to Coordinate(3667F,6979F), "관악" to Coordinate(3433F,6977F),"석수" to Coordinate(3201F,6938F),"신창" to Coordinate(9219F,8725F),"온양온천" to Coordinate(9151F,8924F),"배방" to Coordinate(8990F,9006F),"탕정" to Coordinate(8727F,8999F),"아산" to Coordinate(8481F,9003F),"쌍용" to Coordinate(8232F,9003F),"봉명" to Coordinate(7976F,9008F),"천안" to Coordinate(7717F,9016F),"두정" to Coordinate(7468F,9012F),"직산" to Coordinate(7203F,9020F),"성환" to Coordinate(6957F,9003F),"평택" to Coordinate(6704F,9019F),"평택지제" to Coordinate(6444F,9008F),"서정리" to Coordinate(6198F,9018F),"송탄" to Coordinate(5926F,9004F),"진위" to Coordinate(5685F,9017F),"오산" to Coordinate(5430F,9004F),"오산대" to Coordinate(5171F,8992F),"세마" to Coordinate(4922F,9000F),)
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

            Log.i("tahyeok", ("\"\" to Coordinate($myx"+"F,$myy" + "F),"))

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

                    binding.include.clock.setOnClickListener(object : View.OnClickListener{
                        override fun onClick(p0: View?) {
                            val intent = Intent(getActivity(), SubwayComeActivity::class.java)
                            intent.putExtra("station", station)
                            startActivity(intent)
                        }
                    })

                    binding.include.exit.setOnClickListener{
                        var intent=Intent(activity, ExitActivity::class.java)
                        intent.putExtra("station", station+"역")
                        startActivity(intent)
                    }

                    binding.include.information.setOnClickListener(object : View.OnClickListener{
                        override fun onClick(p0: View?) {
                            val intent = Intent(getActivity(), SubwayComeActivity::class.java)
                            startActivity(intent)
                        }

                    })

                    binding.include.favorite.setOnClickListener(object : View.OnClickListener{
                        override fun onClick(p0: View?) {

                        }

                    })


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