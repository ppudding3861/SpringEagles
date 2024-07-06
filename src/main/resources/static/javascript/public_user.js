document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);

    // 로그인 페이지 오류 및 로그아웃 메시지
    const errorParam = window.errorParam;
    const logoutParam = window.logoutParam;

    if (errorParam === 'true') {
        Swal.fire({
            toast: true,
            position: 'top-end',
            icon: 'error',
            title: '회원의 아이디 또는 비밀번호가 일치하지 않습니다',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            customClass: {
                popup: 'custom-font'
            },
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer);
                toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
        });
    }

    if (logoutParam === 'true') {
        Swal.fire({
            toast: true,
            position: 'top-end',
            icon: 'success',
            title: '성공적으로 로그아웃 되었습니다',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            customClass: {
                popup: 'custom-font'
            },
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer);
                toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
        });
    }

    // 회원 가입 페이지 오류 메시지
    const IdError = window.IdError;
    const EmailError = window.EmailError;

    if (IdError) {
        Swal.fire({
            toast: true,
            position: 'top-end',
            icon: 'error',
            title: '이미 존재하는 아이디입니다',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            customClass: {
                popup: 'custom-font'
            },
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer);
                toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
        });
    }

    if (EmailError) {
        Swal.fire({
            toast: true,
            position: 'top-end',
            icon: 'error',
            title: '이미 존재하는 이메일입니다',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            customClass: {
                popup: 'custom-font'
            },
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer);
                toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
        });
    }

    // 회원 가입 성공 메시지
    if (urlParams.get('success') === 'true') {
        Swal.fire({
            toast: true,
            position: 'top-end',
            icon: 'success',
            title: '회원 가입이 성공적으로 완료되었습니다!',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            customClass: {
                popup: 'custom-font'
            },
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer);
                toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
        });
    }
});
