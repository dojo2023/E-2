/**
 *
 */
//現在の時間を取得する
const hour = new Date().getHours();

//朝4時〜10時59分まで
if(hour >= 4 && hour < 11){
document.getElementById('greeting').textContent ="1日の始まりが、君と同じくらい輝いてることを願っているよ。";
//昼１１時〜1６時59分まで
}else if(hour >=11 && hour <17){
document.getElementById('greeting').textContent ="君と一緒にスヌーズボタンを押したいよ。";
//夜18時〜3時59分まで
}else{
document.getElementById('greeting').textContent ="遅くまでお疲れ様です。";
}

// ログイン時の処理
//フォームを取得する
const form = document.forms[0];
//エラーメッセージを出力する要素を取得する
const error = document.querySelector('.error');

function mit(){
     //社員IDの値を取得する
    //パスワードの値を取得する
    let STAFF_ID = document.getElementById('login_id');
    let PASSWORD =document.getElementById('login_pw');
	console.log(STAFF_ID);
	console.log(PASSWORD);
    //社員ID・パスワードが空または、どちらかにしか入力していないのであれば
    if( !STAFF_ID.value || !PASSWORD.value){
        //エラーメッセージを出力する
        error.textContent = "※社員IDとパスワードを入力してください!";
        //submitイベントを止める
        event.preventDefault();
    return false}

}