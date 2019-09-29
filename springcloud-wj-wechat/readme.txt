 第一步：获取AppID AppSecret(不做解释，自己去微信公众平台申请)

第二步：生成扫描二维码，获取code
https://open.weixin.qq.com/connect/qrconnect?appid=AppID&redirect_uri=http://www.baidu.com&response_type=code&scope=snsapi_login&state=2014#wechat_redirect

第三步：通过code获取access_token
https://api.weixin.qq.com/sns/oauth2/access_token?appid=AppID&secret=AppSecret&code=00294221aeb06261d5966&grant_type=authorization_code

第四步：因接口频率有次数限制，如果需要，刷新access_token
https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=AppID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN

第五步：通过access_token和openid获取用户的基础信息，包括头像、昵称、性别、地区
https://api.weixin.qq.com/sns/userinfo?access_token=bezXEiiBSKSxW0eoblIewFNHqAG-PyW9OqI_L81E4ZCi2cFpfoJTyQc0xKlPPCtqK1kLJfiRbVrpoOVLw7fjpqh52bn7C68SHa2HSgYsVPXZPvJvtayDa57-_7TeHYw&openid=o39YsbmuV_bIPGpj1MTe
