package com.holdice.dataStructure.stackAndQueue.thread;

class EchoNum extends Thread {

    private IsNum isNum;

    @Override
    public void run() {
        while (isNum.numberPrint < 100) {
            synchronized (isNum) {
                if (isNum.flag) {
                    System.out.println(isNum.numberPrint);
                    isNum.numberPrint ++;
                    isNum.flag = false;
                    isNum.notifyAll();
                } else {
                    try {
                        isNum.wait();
                    } catch (InterruptedException e) {
                        new RuntimeException(e);
                    }
                }
            }
        }
    }

    public EchoNum(String name, IsNum isNum) {
        super(name);
        this.isNum = isNum;
    }
}
