package com.kk.cheapter6;

public class Gate {

    private String userName = "noBody";
    private String address = "noWhere";
    private int count = 0;


    public synchronized void pass(String userName, String address) {
        count++;
        this.address = address;
        this.userName = userName;
        verify();
    }

    private void verify() {
        if (this.address.charAt(0) != this.userName.charAt(0)) {
            System.out.println(this.count+"**********BROKEN*************" + toString());
        }
    }

    @Override
    public String toString() {
        return "userName='" + userName + '\'' +
                        ", address='" + address;
    }
}
