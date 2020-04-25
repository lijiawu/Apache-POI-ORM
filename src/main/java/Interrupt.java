public class Interrupt {

    public static final long LONG_LONG_TIME = 5000L;

    public void process() {

        Thread worker = new Thread() {
            User user0 = new User("user0", this);
            User user1 = new User("user1", this);
            @Override
            public void run() {
                super.run();
                while (true) {
                    user0.doSth();
                    user1.doSth();
                }
            }
        };
        worker.start();
        sleepWith(LONG_LONG_TIME);
        worker.interrupt();
    }

    private class User {
        String name;
        Thread worker;

        User(String name, Thread worker) {
            this.name = name;
            this.worker = worker;
        }
        public void doSth() {
            if (worker.interrupted()) {
                System.out.println(name + " said my thread is interrupted, " +
                        "I need to do something");
            }
        }
    }

    public static void sleepWith(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
//        Interrupt interrupt = new Interrupt();
//        interrupt.process();

        int b = 0;
        double a = 1.0 / b;
        System.out.println("What's a:" + a);
    }
}
