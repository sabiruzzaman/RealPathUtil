    public static void DatePicker(Context context, TextView show) {
        Calendar startInstance = Calendar.getInstance();

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        final String[] dateOfBirth = {""};

        DatePickerDialog mDatePickerDialog = new DatePickerDialog(context, (view, year, monthOfYear, dayOfMonth) -> {

            if (String.valueOf((monthOfYear + 1)).length() == 1) {

                if (String.valueOf(dayOfMonth).length() == 1) {

                    dateOfBirth[0] = year + "-0" + (monthOfYear + 1) + "-0" + dayOfMonth;
                } else {
                    dateOfBirth[0] = year + "-0" + (monthOfYear + 1) + "-" + dayOfMonth;
                }
            } else {
                dateOfBirth[0] = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }

            startInstance.set(year, monthOfYear, dayOfMonth, 0, 0);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirth[0] = GlobalData.getStringInEnglish(dateFormat.format(startInstance.getTime()));
            show.setText(dateFormat.format(startInstance.getTime()));

        }, mYear, mMonth, mDay);

        mDatePickerDialog.show();
        mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);


    }
