/**
 * 支付抽象类或者接口
 */
class test{

    /**
     * 支付宝支付
     */
    static class AliPay extends Pay {
        @Override
        public String pay() {
            System.out.println("支付宝pay");
            return "success";
        }
    }
    /**
     * 微信支付
     */
    static class WeixinPay extends Pay {
        @Override
        public String pay() {
            System.out.println("微信Pay");
            return "success";
        }
    }
    /**
     * 银联支付
     */
    static class YinlianPay extends Pay {
        @Override
        public String pay() {
            System.out.println("银联支付");
            return "success";
        }
    }

    public static void main(String[] args) {
        /**
         * 测试支付宝支付多态应用
         */
        Pay pay = new AliPay();
        pay.pay();
        /**
         * 测试微信支付多态应用
         */
        pay = new WeixinPay();
        pay.pay();
        /**
         * 测试银联支付多态应用
         */
        pay = new YinlianPay();
        pay.pay();
    }
}
