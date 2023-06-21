/**
 *
 */
//現在の時間を取得する
const hour = new Date().getHours();

//朝4時〜10時59分まで
if(hour >= 4 && hour < 11){
document.getElementById('greeting').textContent ="おはようございます！";
//昼１１時〜1６時59分まで
}else if(hour >=11 && hour <17){
document.getElementById('greeting').textContent ="こんにちは！";
//夜18時〜3時59分まで
}else{
document.getElementById('greeting').textContent ="こんばんは！";
}
// ログイン時の処理
var formObj = document.getElementById('login_form');
let staff_id = document.getElementById('login_staff_id_id');
let password =document.getElementById('login_password');
var errorMessageObj = document.getElementById('error_message');
formObj.onsubmit = function() {
  if (!staff_id.value || !password.value) {
    errorMessageObj.textContent = '※IDとパスワードを入力してください!';
    return false;
  }
  errorMessageObj.textContent = null;
};
