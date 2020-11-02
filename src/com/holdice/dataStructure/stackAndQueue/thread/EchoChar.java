package com.holdice.dataStructure.stackAndQueue.thread;

class EchoChar extends Thread {
    private char character;

    private IsNum isNum;
    public EchoChar(String name,IsNum isnum){
        super(name);
        this.isNum=isnum;
    }
    @Override
    public void run(){
        while(isNum.numberPrint<100){
            synchronized (isNum) {
                if(!isNum.flag) {
                    System.out.println((char) (96 + isNum.wordPrint));
                    isNum.wordPrint++;
                    if (isNum.wordPrint == 26) {
                        isNum.wordPrint = 0;
                    }
                    isNum.flag=true;
                    isNum.notifyAll();
                }else{
                    try{
                        isNum.wait();
                    }catch (InterruptedException e){
                        new RuntimeException(e);
                    }
                }
            }
        }
    }
}