var regexMap = {
    loginname:/^[0-9_a-z_A-Z]{6,25}$/,
    phone:/^[1][3,4,5,7,8][0-9]{9}$/,
    password : /^[\S]{6,16}$/,
    phoneVerifyCode:/^[0-9a-zA-Z]{4,7}$/,
    verifyCode : /^[0-9a-zA-Z]{4}$/,
    decimalAmount : /^(0\.((0[1-9])|([1-9]\d?)))|([1-9]\d*(\.\d{1,2})?)$/,
    integerAmount : /^[1-9]{1}\d*$/,
    hundredAmount : /^[1-9]{1}\d*00$/,
    cardNumber : /^\d{16}\d*$/,
    idcard : /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[012]))((0[1-9])|([12]\d)|(3[01]))\d{3}?[\dxX]$/
};

//function validateRegex(value, element, param){
//    return this.optional(element) || (regexMap[param].test(value));
//}
function validateRegex(value, param){
    return  (regexMap[param].test(value));
}
