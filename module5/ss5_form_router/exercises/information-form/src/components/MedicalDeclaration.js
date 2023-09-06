import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as Yup from 'yup';
export function MedicalDeclaration() {
    return (
        <>
            <Formik
                initialValues={
                    {
                        name: '',
                        passport: '',
                        yearOfBirth: '',
                        gender: '1',
                        nationalty: '',
                        company: '',
                        department: '',
                        healthIsuranceCard: '',
                        cityName: '',
                        district: '',
                        detailAddress: '',
                        numberphone: '',
                        email: '',
                        arrivedCountry: [],
                        signal: [],
                        contactPerson: []
                    }
                }
                validationSchema={Yup.object({
                    name: Yup.string()
                        .required("Tên không được để trống!")
                        .min(3, "Tên quá ngắn!")
                        .max(30, "Tên quá dài!")
                        .matches(/^[a-z A-Z]+$/, "Tên không hợp lệ"),
                    passport: Yup.string()
                        .required("Số hộ chiếu không được để trống!"),
                    yearOfBirth: Yup.string()
                        .required("Năm sinh không được để trống!")
                        .min(new Date('1900-01-01'), "Năm sinh không hợp lệ!"),
                    nationalty: Yup.string()
                        .required("Quốc tịch không đưcoj để trống!"),
                    cityName: Yup.string()
                        .required("Tỉnh thành không được để trống!"),
                    district: Yup.string()
                        .required("Quận huyện không được để trống!"),
                    detailAddress: Yup.string()
                        .required("Địa chỉ chi tiết không được để trống!"),
                    phone: Yup.string()
                        .required("Số điện thoại không được để trống")
                        .matches(/(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/, "Số điện thoại không hợp lệ"),
                    email: Yup.string()
                        .required("Name is not empty!")
                        .matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, "Email không hợp lệ")
                })}
                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                        setSubmitting(false);
                        console.log(values);
                        alert("Tờ khai y tế của bạn đã hoàn thành!");
                    }, 2000)
                }}
            >
                {
                    <div className="container">
                        <h1>Tờ khai y tế</h1>
                        <Form>
                            <div className='mb-3'>
                                <label htmlFor='name' className='form-label'>Họ và tên:</label>
                                <Field type='text' className='form-control' id='name' name='name' />
                                <ErrorMessage name="name" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='passport' className='form-label'>Số hộ chiếu:</label>
                                <Field name="passport" type='number' className='form-control' id='passport' />
                                <ErrorMessage name="passport" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='yearOfBirth' className='form-label'>Năm sinh:</label>
                                <Field name="yearOfBirth" type='number' className='form-control' id='yearOfBirth' />
                                <ErrorMessage name="yearOfBirth" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'> Giới tính:
                                <div className="form-check form-check-inline">
                                    <Field className="form-check-input" type="radio" id="inlineRadio1"
                                        value="1" name="gender" />
                                    <label className="form-check-label" htmlFor="inlineRadio1">Nam</label>
                                </div>
                                <div className="form-check form-check-inline">
                                    <Field name="gender" className="form-check-input" type="radio" id="inlineRadio2"
                                        value="0" />
                                    <label className="form-check-label" htmlFor="inlineRadio2">Nữ</label>
                                </div>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='nationality' className='form-label'>Quốc tịch:</label>
                                <Field name="nationality" type='text' className='form-control' id='nationality' />
                                <ErrorMessage name="nationality" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='company' className='form-label'>Công ty làm việc</label>
                                <Field name="company" type='text' className='form-control' id='company' />
                                <ErrorMessage name="company" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='department' className='form-label'>Bộ phận làm việc</label>
                                <Field name="department" type='text' className='form-control' id='department' />
                                <ErrorMessage name="department" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='healthIsuranceCard' className='form-label'>Có thẻ bảo hiểm y tế</label>
                                <Field name="healthIsuranceCard" type='checkbox' className='form-control' id='healthIsuranceCard' />
                                <ErrorMessage name="healthIsuranceCard" component='span' className="form-error" />
                            </div>
                            <h2 className="mb-3">Địa chỉ liên lạc tại Việt Nam</h2>
                            <div className='mb-3'>
                                <label htmlFor='cityName' className='form-label'>Tỉnh thành</label>
                                <Field name="cityName" type='text' className='form-control' id='cityName' />
                                <ErrorMessage name="cityName" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='district' className='form-label'>Quận huyện</label>
                                <Field name="district" type='text' className='form-control' id='district' />
                                <ErrorMessage name="cityName" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='detailAddress' className='form-label'>Số nhà, phố, tổ dân phố /thôn /đội: </label>
                                <Field name="detailAddress" type='text' className='form-control' id='detailAddress' />
                                <ErrorMessage name="detailAddress" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='numberphone' className='form-label'>Số điện thoại</label>
                                <Field name="numberphone" type='text' className='form-control' id='numberphone' />
                                <ErrorMessage name="numberphone" component='span' className="form-error" />
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='email' className='form-label'>Email</label>
                                <Field name="email" type='text' className='form-control' id='email' />
                                <ErrorMessage name="email" component='span' className="form-error" />
                            </div>
                            <div className="mb-3">
                                <h2 className="mb-3">Trong vòng 14 ngày qua, anh/chị có đến quốc gia, vùng lãng thổ nào không? </h2>
                                <Field name="arrivedCountry" type='text' className='form-control' id='numberphone' />
                                <ErrorMessage name="arrivedCountry" component='span' className="form-error" />
                            </div>
                            <div className="mb-3">
                                <h2>Trong vòng 14 ngày qua anh chị có thấy xuất hiện các dấu hiệu nào sau đây không'</h2>
                                <Field name="signal" type="checkbox" value="Sốt" /> <label>Sốt</label>
                                <Field name="signal" type="checkbox" value="Ho" /> <label>Ho</label>
                                <Field name="signal" type="checkbox" value="Khó thở" /> <label>Khó thở</label>
                                <Field name="signal" type="checkbox" value="Viêm phổi" /> <label>Viêm phổi</label>
                                <Field name="signal" type="checkbox" value="Đau họng" /> <label>Đau họng</label>
                                <Field name="signal" type="checkbox" value="Mệt mỏi" /> <label>Mệt mỏi</label>
                            </div>
                            <div className="mb-3">
                                <h2>Trong vọng 14 ngày qua, anh chị có tiếp xúc với?</h2>
                                <Field name="contactPerson" type="checkbox" value="Người bệnh hoặc nghi ngờ" /> <label>Người bệnh hoặc nghi ngờ mắc bệnh COVID-19</label>
                                <Field name="contactPerson" type="checkbox" value="Người từ nước có bệnh" /> <label>Người từ nước có bệnh COVID-19</label>
                                <Field name="contactPerson" type="checkbox" value="Người có biểu hiện bệnh" /> <label>Người có biểu hiện (sốt, ho, khó thở, viêm phổi)</label>
                            </div>
                            <div className="mb3">
                                <button type="submit">Submit</button>
                            </div>
                        </Form>
                    </div >
                }
            </Formik >
        </>
    )
}