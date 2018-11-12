package com.example.advancedcalculator.module.general;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.base.BaseFragment;
import com.example.advancedcalculator.util.CalculatorUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class GeneralFragment extends BaseFragment implements GeneralContract.View {
    private static final String TAG = "GeneralFragment";
    
    @BindView(R.id.rl_screen)
    RelativeLayout mRlScreen;
    
    @BindView(R.id.tv_num)
    TextView mTvNum;
    
    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;
    
    @BindView(R.id.btn_AC)
    TextView mBtnAC;
    
    @BindView(R.id.btn_7)
    TextView mBtn7;
    
    @BindView(R.id.btn_4)
    TextView mBtn4;
    
    @BindView(R.id.btn_1)
    TextView mBtn1;
    
    @BindView(R.id.btn_del)
    RelativeLayout mBtnDel;
    
    @BindView(R.id.btn_8)
    TextView mBtn8;
    
    @BindView(R.id.btn_5)
    TextView mBtn5;
    
    @BindView(R.id.btn_2)
    TextView mBtn2;
    
    @BindView(R.id.btn_0)
    TextView mBtn0;
    
    @BindView(R.id.btn_divide)
    TextView mBtnDivide;
    
    @BindView(R.id.btn_9)
    TextView mBtn9;
    
    @BindView(R.id.btn_6)
    TextView mBtn6;
    
    @BindView(R.id.btn_3)
    TextView mBtn3;
    
    @BindView(R.id.btn_point)
    TextView mBtnPoint;
    
    @BindView(R.id.btn_multiply)
    TextView mBtnMultiply;
    
    @BindView(R.id.btn_subtract)
    TextView mBtnSub;
    
    @BindView(R.id.btn_add)
    TextView mBtnAdd;
    
    @BindView(R.id.btn_equal)
    TextView mBtnEqual;

    private StringBuffer mMoney = new StringBuffer("");

    private static GeneralPresenter mPresenter = GeneralPresenter.newInstance();

    
    public static final GeneralFragment newInstance() {
        return new GeneralFragment();
    }
    
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_general;
    }
    
    @Override
    public void initViews() {
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, root);
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_point, R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply,
            R.id.btn_divide, R.id.btn_percent, R.id.btn_equal, R.id.btn_del, R.id.btn_AC})
    public void onClickNum(View view) {
        Log.e(TAG, mMoney.toString() + "长度：" + mMoney.length());
        switch (view.getId()) {
            case R.id.btn_AC:
                //清空文本内容
                mMoney.delete(0, mMoney.length());
                mMoney = new StringBuffer("");
                break;
            case R.id.btn_0:
                //如果长度大于0且首位不为0
                if (mMoney.length() > 0 && mMoney.charAt(0) != '0') {
                    mMoney.append(0);
                    Log.d(TAG, "点击0");
                }
                break;
            case R.id.btn_1:
                mMoney.append("1");
                break;
            case R.id.btn_2:
                mMoney.append("2");
                break;
            case R.id.btn_3:
                mMoney.append("3");
                break;
            case R.id.btn_4:
                mMoney.append("4");
                break;
            case R.id.btn_5:
                mMoney.append("5");
                break;
            case R.id.btn_6:
                mMoney.append("6");
                break;
            case R.id.btn_7:
                mMoney.append("7");
                break;
            case R.id.btn_8:
                mMoney.append("8");
                break;
            case R.id.btn_9:
                mMoney.append("9");
                break;
            case R.id.btn_point:
                //如果长度为0，则补0
                if (mMoney.toString().length() == 0)
                    mMoney.append("0");
                //如果最后一个为符号，则补0
                mPresenter.addZeroIfChar(mMoney);
                mMoney.append(".");
                break;
            case R.id.btn_del:
                //如果长度不为0，则去掉末尾
                if (mMoney.length() > 0) {
                    mMoney.deleteCharAt(mMoney.length() - 1);
                }
                break;
            case R.id.btn_add:
                if (mMoney.length() != 0){
                    //如果最后一位是.，则先补0
                    mPresenter.addZeroIfPoint(mMoney);
                }
                mPresenter.deleteLastStr(mMoney);
                mMoney.append("+");
                break;
            case R.id.btn_subtract:
                if (mMoney.length() != 0){
                    //如果最后一位是.，则先补0
                    mPresenter.addZeroIfPoint(mMoney);
                }
                //TODO 负号
                mPresenter.deleteLastStr(mMoney);
                mMoney.append("-");
                break;
            case R.id.btn_multiply:
                if (mMoney.length() != 0){
                    //如果最后一位是.，则先补0
                    mPresenter.addZeroIfPoint(mMoney);
                }
                mPresenter.deleteLastStr(mMoney);
                mMoney.append("*");
                break;
            case R.id.btn_divide:
                if (mMoney.length() != 0){
                    //如果最后一位是.，则先补0
                    mPresenter.addZeroIfPoint(mMoney);
                }
                mPresenter.deleteLastStr(mMoney);
                mMoney.append("÷");
                break;
            case R.id.btn_percent:
                mPresenter.deleteLastStr(mMoney);
                mMoney.append("%");
                break;
            case R.id.btn_equal:
                Log.e(TAG, "长度是" + mMoney.length());
                String result = CalculatorUtils.calculate(CalculatorUtils.Suffix(mMoney));
                Log.e(TAG, "运算结果：" + result);
                break;
        }
        //如果已输入，将AC换成C
        if (mMoney.length() > 0) {
            mBtnAC.setText("C");
        }
        if (mMoney.equals("") || mMoney.length() == 0) {
            mBtnAC.setText("AC");
            mTvNum.setText("0");
        } else {
            mTvNum.setText(mMoney);
        }
    }

}








