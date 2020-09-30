package com.example.ir;

import android.content.Context;
import android.hardware.ConsumerIrManager;

public class TransmitFacade {
    static void transmit(Context context,int frequency,int[] pattern){
        ConsumerIrManager consumerIrManager = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
        consumerIrManager.transmit(frequency, pattern);
    }
}
