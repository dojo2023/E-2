//現在の時間を取得する
const hour = new Date().getHours();

//朝4時〜10時59分まで
if(hour >= 4 && hour < 11){
document.getElementById('greeting').textContent ="おはよう！ 君が僕の人生にいてくれるなんて、本当に恵まれているよ。";
//昼１１時〜1６時59分まで
}else if(hour >=11 && hour <17){
document.getElementById('greeting').textContent ="こんにちは！";
//夜18時〜3時59分まで
}else{
document.getElementById('greeting').textContent ="お疲れ様でした！";
}