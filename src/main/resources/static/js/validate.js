/*
function goodsCheckInformation() {
    //校验类别名称
    const name = document.getElementById("goodsName").value;
    if (name === "") {
        layer.msg("请输入商品名称！")
        return false;
    } else if (name.length < 2 || name.length > 12) {
        alert("商品名称长度必须为2—20个字符！");
        return false;
    }

    const goodsId = document.getElementById("goodsId").value;
    if (goodsId === "") {
        layer.msg("请输入商品ID！")
        return false;
    }

    const img = document.getElementById("goodsImg").value;
    if (img == "") {
        layer.msg("请选择文件路径！")
        return false;
    }

    const price = document.getElementById("goodsPrice").value;
    if (price == "") {
        layer.msg("请输入商品价格！")
        return false;
    }

    if (!(/^[0-9]+.?[0-9]{0,2}$/.test(price))) {
        layer.msg("商品价格为数字！")
        return false;
    }


    const num = document.getElementById("goodsNum").value;
    if (num == "") {
        layer.msg("请输入商品库存！")
        return false;
    }

    if (!(/^[0-9]*$/.test(num))) {
        layer.msg("商品库存为数字！")
        return false;
    }


    const desc = document.getElementById("goodDesc").value;
    if (desc.length > 400) {
        layer.msg("商品描述长度不能超过400个字符！")
        return false;
    }

    const tid = document.getElementById("goodsTid").value;
    if (tid == "" || tid == "-1") {
        layer.msg("请选择商品类别！")
        return false;
    }
    return true;
}

function typeCheckInformation() {
    //校验类别名称
    let name = document.getElementById("name").value;
    if (name === "") {
        layer.msg("请输入类别名称！")
        return false;
    } else if (name.length < 2 || name.length > 12) {
        alert("类别名称长度必须为2—12个字符！");
        return false;
    }

    let id = document.getElementById("id").value;
    if (id ==="") {
        layer.msg("请输入类别ID！")
        return false;
    }

    let desc = document.getElementById("desc").value;
    if (desc.length > 40) {
        layer.msg("类别描述长度不能超过40个字符！")
        return false;
    }

    return true;
}

function managerCheckInformation() {
    //校验类别名称
    const id = document.getElementById("id").value;
    if (id === "") {
        layer.msg("请输入管理员ID！")
        return false;
    }

    const img = document.getElementById("imgSRC").value;
    if (img == "") {
        layer.msg("请选择文件路径！")
        return false;
    }

    const name = document.getElementById("name").value;
    if (name === "") {
        layer.msg("请输入管理员名称！")
        return false;
    }



    const account = document.getElementById("account").value;
    if (account === "") {
        layer.msg("请输入管理员帐号！")
        return false;
    }


    const password = document.getElementById("password").value;
    if (password === "") {
        layer.msg("请输入管理员密码！")
        return false;
    }

    const passwordRep = document.getElementById("passwordRep").value;
    if (passwordRep === "") {
        layer.msg("请再次输入管理员密码！")
        return false;
    }
    
    if (password !== passwordRep) {
        layer.msg("两次密码不一致，请重新输入！")
        return false;
    }

    const tel = document.getElementById("tel");
    return true;
}*/
