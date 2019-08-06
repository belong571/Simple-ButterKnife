# Simple-ButterKnife
一个轻量级的‘黄油刀’注入框架
#添加依赖
```
implementation 'com.github.belong571:Simple-ButterKnife:v1.0.0'
```
#简单使用
```
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @OnClick({R.id.button})  //可注入多个view  {R.id.button,R.id.textView}
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                textView.setText("我是手写ButterKnife框架");
                break;
            default:
                Log.e("MainActivity","view not found");
                break;
        }
    }

    @OnLongClick({R.id.button})  //可注入多个view  {R.id.button,R.id.textView}
    public void onLongClick(View view){
        switch (view.getId()){
            case R.id.button:
                textView.setText("button  长按了");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);   不再需要setContentView了  因为注解已经帮我们完成了
        ButterKnife.inJect(this); //可以在BaseActivity添加这句
    }
}
```